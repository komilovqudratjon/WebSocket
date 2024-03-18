package uz.koinot.socket.webSocket.heldler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;

/**
 * @description: TODO
 * @date: 18 March 2024 $
 * @time: 8:12 PM 51 $
 * @author: Qudratjon Komilov
 */
@Slf4j
public class SocketNajot implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection established on session: {}", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payload = (String) message.getPayload();
        log.info("Message: {}", payload);
        session.sendMessage(new TextMessage("i didn't get your point"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("Exception : {}", exception.getMessage());

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection closed on session: {}", session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
