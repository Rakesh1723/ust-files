package notification.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotification implements Sms{

    @Override
    public void send(String senderNo) {
        System.out.println("Sending notification via Sms from "+senderNo);
    }

    @Override
    public void receive(String receiverNo) {
        System.out.println("Receiving notification via Sms from "+receiverNo);
    }

}
