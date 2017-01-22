package demo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import sdk.interfaces.entity.other.OMessage;
import sdk.util.CallbackValidationUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("server start at: " + address.getAddress() + ":" + address.getPort());
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
                Map<String, String> responseMap = new HashMap();
                responseMap.put("message", response);
                String message = mapper.writeValueAsString(responseMap);

                t.sendResponseHeaders(code, message.length());
                OutputStream os = t.getResponseBody();
                os.write(message.getBytes());
                os.close();
            }
        }
    }
}
