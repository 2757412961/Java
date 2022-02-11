package main.java.edu.zju.zjh.gof23.builder.buliderThis;

public abstract class Builder {

    abstract Builder buildA(String a);

    abstract Builder buildB(String b);

    abstract Builder buildC(String c);

    abstract Builder buildD(String d);

    abstract Product getProduct();

}
