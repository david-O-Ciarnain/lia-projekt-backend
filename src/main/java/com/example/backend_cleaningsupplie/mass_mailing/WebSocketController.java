package com.example.backend_cleaningsupplie.mass_mailing;


import com.example.backend_cleaningsupplie.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebSocketController {


    private SimpMessagingTemplate simpMessagingTemplate;
    private MessagesService messagesService;


    @MessageMapping("messages")
    @SendTo("//chatroom/public")
    public Messages receiveMessage(@Payload Messages messages){
        messagesService.saveMessage(messages);
        return messages;
    }
    //this is if someone wants to make user able to send messages to each other
    @MessageMapping("private-messages")
    public Messages recMessages(@Payload Messages messages){

        simpMessagingTemplate.convertAndSendToUser(messages.getReceiverName(),"private",messages);// user/userName/private/message
        messagesService.saveMessage(messages);
        System.out.println(messages.toString());
        return messages;
    }
}
