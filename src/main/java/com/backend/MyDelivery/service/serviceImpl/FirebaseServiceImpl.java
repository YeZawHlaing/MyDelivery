package com.backend.MyDelivery.service.serviceImpl;


import com.backend.MyDelivery.service.FirebaseService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements FirebaseService {
    @Override
    public String sendNotification(String title, String body, String token) {
        try {
            Message message = Message.builder()
                    .setToken(token)
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .build();

            // Send the message and get the message ID
            String response = FirebaseMessaging.getInstance().send(message);
            return "Notification sent successfully, ID: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending notification: " + e.getMessage();
        }
    }

}
