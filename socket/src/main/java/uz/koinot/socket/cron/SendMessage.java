package uz.koinot.socket.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.koinot.socket.stompWebSocket.model.Greeting;
import uz.koinot.socket.stompWebSocket.model.Message;

/**
 * @description: TODO
 * @date: 19 March 2024 $
 * @time: 1:52 PM 28 $
 * @author: Qudratjon Komilov
 */
@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class SendMessage {

    private final SimpMessagingTemplate messagingTemplate;
    @Scheduled(fixedDelay = 1000L)
    public void sendSocket() {
        log.info("I am working");
        sendMessageToGreetingsTopic("Hello");
    }

    public void sendMessageToGreetingsTopic(String message) {
        Greeting greeting = new Greeting(message); // Assuming you have a Greeting class that takes a String
        messagingTemplate.convertAndSend("/topic/greetings", greeting);
    }

}
