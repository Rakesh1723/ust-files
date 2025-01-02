package notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class Phone {

    @Autowired
    private Email emailNotification;

    @Autowired
    private Sms smsNotification;

    @Value("${sender}")
    private String senderNo;
    @Value("${receiver}")
    private String receiverNo;


    public void receiveViaSms() {
        smsNotification.receive(receiverNo);
    }

    public void sendViaSms() {
        smsNotification.send(senderNo);
    }

    public void receiveViaEmail() {
        emailNotification.receive(receiverNo);
    }

    public void sendViaEmail() {
        emailNotification.send(senderNo);
    }

}
