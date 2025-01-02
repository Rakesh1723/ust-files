package notification.service;

public interface Sms {

    public void send(String senderNo);
    public void receive(String receiverNo);
}
