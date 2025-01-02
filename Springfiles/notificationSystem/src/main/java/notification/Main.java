package notification;

import notification.configuration.Config;
import notification.service.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        Phone p1=context.getBean(Phone.class);
        p1.sendViaEmail();
        p1.receiveViaEmail();
        p1.sendViaSms();
        p1.receiveViaSms();

    }
}
