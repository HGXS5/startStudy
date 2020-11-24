package com.han.demo5;

public class NoNameInner2 {
    NoNameInner3 inner3 = new NoNameInner3();

    /* public NoNameInner2(){
         inner3.listener(new NoNameInner1());
     }*/
    public NoNameInner2() {
        inner3.listener(new NoNameInner6() {
                            @Override public void noName() {
                                System.out.println("我现在成为了匿名内部类了。哈哈！！！！！！");
                            }
                        }
        );
    }

    public static void main(String[] args) {
        new NoNameInner2();
    }
}
