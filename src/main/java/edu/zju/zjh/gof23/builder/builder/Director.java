package main.java.edu.zju.zjh.gof23.builder.builder;

public class Director {

    public Product build() {
        Builder worker = new Worker();
        worker.buildD();
        worker.buildA();
        worker.buildB();
        worker.buildC();

        return worker.getProduct();
    }

    public static void main(String[] args) {
        System.out.println(new Director().build().toString());
    }

}
