package notification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements Email{


    @Override
    public void send(String senderNo) {
        System.out.println("Sending notification via Email from "+senderNo);
    }

    @Override
    public void receive(String receiverNo) {
        System.out.println("Receiving notification via Email from "+receiverNo);
    }

}
