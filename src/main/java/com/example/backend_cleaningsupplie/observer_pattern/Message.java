package com.example.backend_cleaningsupplie.observer_pattern;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


public class Message implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private String messageHeader;
    private String message;
    private Observer observer;


    public Message(String messageHeader, String message) {
        this.messageHeader = messageHeader;
        this.message = message;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
    observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer users: observerList){
            users.update(this.observer,this.messageHeader,this.message);
        }
    }

    @Override
    public void setMessage(Observer observer, String newMessage) {
        if (newMessage != null || !newMessage.isEmpty() || !newMessage.isBlank()) {
            this.observer = observer;
            this.message = newMessage;
            notifyObservers();
        }

    }
}
