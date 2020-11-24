package com.han.demo11;

import test.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test1 {

    private Test1(){
        throw new AssertionError();
    }

    public static void main(String[] args) {
        Person p = new Person();
//        final Object name = getValue(p, "name");
        setValue(p,"name","小明");
        final Object name = getValue(p, "name");
        System.out.println(name);
    }
    /**
     * 通过反射获取对象指定字段（属性）的值
     * @param target 目标对象
     * @param filedName 字段的名称
     * @return 字段的值
     */
    public static Object getValue(Object target, String filedName) {
        /**
         * 1. getClass()方法 返回此对象的运行时类。返回的Class对象是被表示的类的静态同步方法锁定的对象 （在Object对象中）
         * 2. split(String regex)方法 围绕给定正则表达式的匹配项拆分此字符串（在String对象中）
         *          参数：
         *              regex:定界正则表达式
         *              （该代码中的参数" \\. ":表示的是 在java中把"\\"识别为"\",
         *                                      识别完后为"\."属于正则表达式，意思是查找元字符"."本身.
         *                                      补充：每个元字符都有特殊意义，当加上"\"时则表示本身）
         *          返回：
         *              通过在给定正则表达式的匹配项周围拆分此字符串而计算出的字符串数组
         * 3. getDeclaredField(String name)方法 返回一个Field对象，该对象反映此Class对象表示的类或接口的指定声明字段（在Class<T>对象中）
         *          参数：
         *              name:字段名称
         *          返回：
         *              此类中指定字段的Field对象
         * 4. setAccessible(boolean flag)方法 将此对象的可访问标志设置为指示的布尔值。（Field对象的父类AccessibleObject中）
         *                                   值为true表示反射对象在使用时应禁止Java语言访问检查
         *                                   值为false表示反射对象应强制执行java语言访问检查
         * 5.
         */
        Class<?> clazz = target.getClass();
        String[] strs = filedName.split("\\.");
        try {
            for (int i = 0; i < strs.length - 1; i++) {
                Field f = clazz.getDeclaredField(strs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(strs[strs.length - 1]);
            f.setAccessible(true);
            return f.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过反射给对象的指定字段赋值
     * @param target 目标对象
     * @param name 字段名称
     * @param value 值
     */
    public static void setValue(Object target,String name,Object value){
        /**
         * 1. get(Object obj)方法 返回指定对象上此Field表示的字段的值。如果值具有原始类型，则该值将自动包装在一个对象中（在Field对象中）
         * 2. getType()方法 返回一个Class对象，该对象标识此Field对象表示的字段的声明类型。（在Field对象中）
         * 3. getDeclaredConstructor(Class<?>...parameterTypes)方法 返回一个构造函数对象，
         *                                              该对象反映此Class对象表示的类或接口的指定构造函数。（在Class<T>对象中）
         *          参数：
         *               parameterTypes参数是Class对象数组，这些Class对象按声明的顺序标识构造函数的形式参数类型。
         *
         *          补充：如果此Class对象表示在非静态上下文中声明的内部类，则形式参数类型包括显式的封闭实例作为第一个参数
         * 4. newInstance(Object...initargs)方法 使用此Constructor对象表示的构造函数，
         *                              使用指定的初始化参数来创建和初始化构造函数的声明类的新实例（该方法在Constructor对象中）
         *           参数：将作为参数传递给构造函数调用的对象数组；基本类型的值包装在适当类型的包装类中
         *
         *           补充：如果基础构造函数所需的形式参数数量为0，则提供的initargs数组长度可以为0可以为null
         * 5. set(Object obj,Object value)方法 将此field对象参数上表示的字段设置为指定的新值。
         *                              如果基础字段具有基本类型，则新值将自动展开
         */
         Class<?> clazz = target.getClass();
         String[] fs = name.split("\\.");
        try {
            for (int i = 0; i < fs.length - 1; i++) {
                 Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                 Object val = f.get(target);
                if (val == null){
                     Constructor<?> c = f.getType().getDeclaredConstructor();
                    c.setAccessible(true);
                    val = c.newInstance();
                    f.set(target,val);
                }
                target = val;
                clazz = target.getClass();
            }
            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
                f.set(target,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
