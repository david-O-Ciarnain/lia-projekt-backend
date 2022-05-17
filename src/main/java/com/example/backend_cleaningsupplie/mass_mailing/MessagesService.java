package com.example.backend_cleaningsupplie.mass_mailing;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class MessagesService {

private MessagesRepo messagesRepo;

public void saveMessage(Messages messages){
    messagesRepo.save(messages);
}


}
