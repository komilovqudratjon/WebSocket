package uz.koinot.socket.webSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import uz.koinot.socket.webSocket.heldler.SocketNajot;

/**
 * @description: TODO
 * @date: 18 March 2024 $
 * @time: 8:30 PM 35 $
 * @author: Qudratjon Komilov
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/najot").setAllowedOrigins("*");
    }

    @Bean
    WebSocketHandler handler(){return new SocketNajot();}

}
