package com.backend.MyDelivery.service;

public interface FirebaseService {

    public String sendNotification(String title, String body, String token);
}
