package main.java.edu.zju.zjh.gof23.factory.simple;

public class CarFactory {

    public static Car getCar(String carType) {
        if (carType.equals("WuLing")) {
            return new WuLing();
        } else if (carType.equals("Tesla")) {
            return new Tesla();
        }

        return null;
    }

}
