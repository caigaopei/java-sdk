package me.ele.shop.demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import me.ele.shop.sdk.interfaces.entity.other.OMessage;
import me.ele.shop.sdk.util.CallbackValidationUtil;

import java.io.*;
import java.net.InetSocketAddress;

public class Callback {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);
        HttpServer server = HttpServer.create(address, 0);
        server.createContext("/callback", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("server start at: " + address.getHostString() + ":" + address.getPort());
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            int code = 200;
            String response = "ok";
            try {
                if ("GET".equals(t.getRequestMethod())) {
                    return;
                }

                InputStream is = t.getRequestBody();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line = null;
                String body = "";
                while ((line = in.readLine()) != null) {
                    body += line;
                }

                OMessage message = null;
                message = mapper.readValue(body, OMessage.class);

                if (!CallbackValidationUtil.isValidMessage(message)) {
                    throw new Exception("invalid post data : " + body);
                }
            } catch (Exception e) {
                e.printStackTrace();
                code = 500;
                response = e.getMessage();
            } finally {
                t.sendResponseHeaders(code, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
