package main.java.edu.zju.zjh.lcold;

import java.util.Random;
import java.util.UUID;
import java.util.function.Consumer;

public class DTest {


    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        Consumer<Dog> dogConsumer = (Dog dog) -> {
            System.out.println(dog.hashCode());
        };


        System.out.println(dog1);
        System.out.println(dog1.toString());
        dogConsumer.accept(dog1);

        System.out.println(dog2);
        System.out.println(dog2.hashCode());

    }

}

class Dog {

    private int id;

    private String name;

    public Dog() {
        this.id = new Random().nextInt();
        this.name = UUID.randomUUID().toString();
    }

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
