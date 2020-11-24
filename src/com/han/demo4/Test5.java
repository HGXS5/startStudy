package com.han.demo4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Test5 {
    class Inner{}
    public static  void foo(){
//        new Inner(); 不可以创建
        new Test5().new Inner();//可以通过现将外部类进行实例化进而再将内部类进行实例化

    }
    public void bar(){
        new Inner();//可以创建
    }

    public static void main(String[] args) {
//        new Inner(); 不可以创建
       //new Test5().new Inner();
        System.out.println(Test2.a);
    }

}
