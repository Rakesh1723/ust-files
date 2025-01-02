package notification.service;

public interface Email {
    public void send(String senderNo);
    public void receive(String receiverNo);
}
