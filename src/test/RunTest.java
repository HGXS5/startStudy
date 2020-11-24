package test;

import com.han.demo1.Demo;
import com.han.demo1.Test2;

public class RunTest {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test();
        System.out.println("--------------------------");
        Demo test2 = new Test2();
        test2.test();
        System.out.println("--------------------------");
        System.out.println("此时的a值为："+test2.a);
        System.out.println(demo.a);
        System.out.println(com.han.demo4.Test2.a);
    }
}
