package com.example.backend_cleaningsupplie.observer_pattern;

public interface Observer {

    void update(Observer observer,String messageHeader,String message);
}
