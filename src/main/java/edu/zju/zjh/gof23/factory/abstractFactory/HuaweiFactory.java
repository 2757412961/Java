package main.java.edu.zju.zjh.gof23.factory.abstractFactory;

public class HuaweiFactory implements IProductFactory {
    @Override
    public IRouterProduct getRouter() {
        return new HuaweiRouter();
    }

    @Override
    public IPhoneProduct getPhone() {
        return new HuaweiPhone();
    }
}
