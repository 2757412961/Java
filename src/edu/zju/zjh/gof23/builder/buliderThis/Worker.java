package edu.zju.zjh.gof23.builder.buliderThis;

public class Worker extends Builder {
    private Product product = new Product();

    @Override
    public Builder buildA(String a) {
        product.setProductA(a);
        return this;
    }

    @Override
    public Builder buildB(String b) {
        product.setProductB(b);
        return this;
    }

    @Override
    public Builder buildC(String c) {
        product.setProductC(c);
        return this;
    }

    @Override
    public Builder buildD(String d) {
        product.setProductD(d);
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
