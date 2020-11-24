package com.han.demo4;

import java.io.*;

public class MyUtils {
    private  MyUtils(){
        //在构造器抛出异常意思就是不能被实例化
        throw new AssertionError();//断言异常
    }
    public static <T extends Serializable> T clone(T Obj) throws Exception{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(Obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        /**
         * 解释：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
         * 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
         */

    }
}
