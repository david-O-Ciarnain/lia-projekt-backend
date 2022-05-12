package com.example.backend_cleaningsupplie.observer_pattern;

public interface Subject {

void registerObserver(Observer observer);
void removeObserver(Observer observer);
void notifyObservers();
void setMessage(Observer observer,String newMessage);
}
