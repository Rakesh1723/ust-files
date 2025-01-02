package org.springapp;

import org.springapp.beans.Phone;
import org.springapp.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        Phone phone=context.getBean("iPhone",Phone.class);
          Phone phone=context.getBean(Phone.class);
//        Phone p1=context.getBean(Phone.class);
        String phnNo="9848187654";
        phone.call(phnNo);
        phone.sendText(phnNo,"Hello..When are you reaching?");
        System.out.println(phone);
    }

}
