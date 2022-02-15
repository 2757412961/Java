package edu.zju.zjh.gof23.builder.buliderThis;


public class Product {

    String productA;

    String productB;

    String productC;

    String productD;

    @Override
    public String toString() {
        return "Product{" +
                "productA='" + productA + '\'' +
                ", productB='" + productB + '\'' +
                ", productC='" + productC + '\'' +
                ", productD='" + productD + '\'' +
                '}';
    }

    public String getProductA() {
        return productA;
    }

    public void setProductA(String productA) {
        this.productA = productA;
    }

    public String getProductB() {
        return productB;
    }

    public void setProductB(String productB) {
        this.productB = productB;
    }

    public String getProductC() {
        return productC;
    }

    public void setProductC(String productC) {
        this.productC = productC;
    }

    public String getProductD() {
        return productD;
    }

    public void setProductD(String productD) {
        this.productD = productD;
    }
}
