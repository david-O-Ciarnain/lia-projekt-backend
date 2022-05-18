package com.example.backend_cleaningsupplie.mass_mailing;


import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebSocketController {


    private MessagesService messagesService;


 @MessageMapping("messages")
    @SendTo("/chatroom")
    public Messages receiveMessage(@Payload Messages fulltext){
        messagesService.saveMessage(fulltext);
        return fulltext;
    }

}
