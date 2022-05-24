package com.example.backend_cleaningsupplie.chatroom;


import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("")
public class WebSocketController {



    private MessagesService messagesService;



 @MessageMapping("messages")
    @SendTo("/chatroom")
    public Messages receiveMessage(@Payload Messages fulltext){
        messagesService.saveMessage(fulltext);
        return fulltext;
    }

}
