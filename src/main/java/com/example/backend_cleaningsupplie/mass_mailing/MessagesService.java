package com.example.backend_cleaningsupplie.mass_mailing;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagesService {

private MessagesRepo messagesRepo;

public Messages saveMessage(Messages messages){

   return messagesRepo.save(messages);
}

public List<Messages> getMessages(Messages messages){
    return messagesRepo.findAll();
}
public void deleteByMessage(String title){
    messagesRepo.deleteMessagesByTitle(title);
}

}
