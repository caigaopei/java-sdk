package me.ele.shop.sdk.interceptor;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.ele.shop.sdk.protocol.Token;

@Data
public final class ClientContext {
    @Getter
    private final ClientContext context = new ClientContext();

    @Getter
    @Setter
    private static Token token;

    private ClientContext() {

    }
}
