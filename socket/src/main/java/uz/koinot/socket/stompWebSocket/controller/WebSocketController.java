package uz.koinot.socket.stompWebSocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import uz.koinot.socket.stompWebSocket.model.Greeting;
import uz.koinot.socket.stompWebSocket.model.Message;

/**
 * @description: TODO
 * @date: 18 March 2024 $
 * @time: 9:29 PM 43 $
 * @author: Qudratjon Komilov
 */
@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) {
        return new Greeting(  message.name() );
    }
}
