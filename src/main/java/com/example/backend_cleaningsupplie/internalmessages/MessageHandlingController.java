package com.example.backend_cleaningsupplie.internalmessages;

import org.springframework.http.HttpOutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "messages")
public class MessageHandlingController {

    @MessageMapping("/secured/chat")
    @SendTo("/secured/history")
   public OutputMessage send(Messages messages) throws Exception{
        return new OutputMessage(
                messages.getFrom(),
                messages.getText(),
                new SimpleDateFormat("HH:mm").format(new Date())
        );
    }
}
