package com.han.demo11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 1. getClass()方法 返回此对象的运行时类。返回的Class对象是被表示的类的静态同步方法锁定对象 （在Object对象中）
         * 2. getMethod(String name,Class<?>... parameterTypes)方法 返回一个Method对象，该对象反映此Class对象表示的类或
         *                                                          接口的指定公共成员方法。
         *            参数：
         *              name:name参数是一个String,用于指定所需方法的简单名称
         *              parameterTypes参数是Class对象数组，这些Class对象按声明顺序标识方法的形式参数类型。
         *                                 如果parameterTypes为null，则将其视为空数组。
         *            返回：
         *              与指定名称和parameterTypes匹配的Method对象。
         * 3. invoke(Object obj,Object... args)方法 在具有指定参数的指定对象上调用此Method对象表示的基础方法
         */
        String s = "han123";
        final Method toUpperCase = s.getClass().getMethod("toUpperCase");
        final Object invoke = toUpperCase.invoke(s);
        System.out.println(invoke);
    }
}
