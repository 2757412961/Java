package edu.zju.zjh.gof23.factory.abstractFactory;

public class XiaomiFactory implements IProductFactory{
    @Override
    public IRouterProduct getRouter() {
        return new XiaomiRouter();
    }

    @Override
    public IPhoneProduct getPhone() {
        return new XiaomiPhone();
    }
}
