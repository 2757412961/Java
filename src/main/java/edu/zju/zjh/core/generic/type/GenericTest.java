package edu.zju.zjh.core.generic.type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/6/8 10:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class GenericTest {

    public static void main(String[] args) {

        // 这样是合法的，虽然混合加入了dog、cat。但都用统一的父类animal作为出口了
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Dog());
        list.add(new Cat());

        // Dog是Animal的一个继承类，但ArrayList<Dog>不是ArrayList<Animal>的继承类，
        // ArrayList<Dog> dogs1 = new ArrayList<Animal>();
        // ArrayList<Animal> animals1 = new ArrayList<Dog>();
        ArrayList<? extends Animal> animals2 = new ArrayList<Dog>();

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        List<Dog> dogList = dogs;

        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objectList = objects;
        // ArrayList<Object> objs = new ArrayList<Dog>();

        // setAnimal(new ArrayList<Dog>());
    }

    public static void setAnimal(ArrayList<Animal> animals) {
        animals.add(new Dog());
        animals.add(new Cat());
    }

}
