package main.java.edu.zju.zjh.gof23.builder.builder;

public class Worker extends Builder {
    private Product product = new Product();

    @Override
    void buildA() {
        product.setProductA("a");
    }

    @Override
    void buildB() {
        product.setProductB("b");
    }

    @Override
    void buildC() {
        product.setProductC("c");
    }

    @Override
    void buildD() {
        product.setProductD("d");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
