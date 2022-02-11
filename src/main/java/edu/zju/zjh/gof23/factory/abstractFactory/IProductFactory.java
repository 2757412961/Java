package main.java.edu.zju.zjh.gof23.factory.abstractFactory;

public interface IProductFactory {

    IRouterProduct getRouter();

    IPhoneProduct getPhone();

}
