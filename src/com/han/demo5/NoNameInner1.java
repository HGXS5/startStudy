package com.han.demo5;

public class NoNameInner1 implements  NoNameInner6{

    @Override
    public void noName() {
        System.out.println("我是NoNameInner6接口中的方法，被NoNameInner1重写了");
    }
    public void inner(){
        System.out.println("我是NoNameInner1类中的自定义的方法");
    }
}
