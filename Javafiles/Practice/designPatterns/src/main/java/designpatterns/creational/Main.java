package designpatterns.creational;

import designpatterns.creational.builder.Pizza;
import designpatterns.creational.builder.PizzaBuilder;

public class Main {
    public static void main(String[] args) {

        Pizza pizza1 = new PizzaBuilder("Medium")
                .withExtraCheese()
                .build();

        System.out.println(pizza1);

        Pizza pizza2 = new PizzaBuilder("Large")
                .withExtraCheese()
                .withPepperoni()
                .build();

        System.out.println(pizza2);

    }
}