package test;

import com.han.demo4.Car;
import com.han.demo4.MyUtils;
import com.han.demo4.Person;

public class CloneTest {
    public static void main(String[] args)  {
        try {
            Person p1 = new Person("han",24,new Car("沃尔沃",200));
            Person p2 = MyUtils.clone(p1);//深度克隆
            p2.getCar().setBrand("现代");
            /**
             *  修改克隆的Person对象p2关联的汽车对象的品牌属性
             *  原来的Person对象p1关联的汽车不会受到影响
             *  因为在克隆Person对象时其关联的汽车对象也被克隆了
             */
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
