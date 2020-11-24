package com.han.demo5;


import java.io.UnsupportedEncodingException;

public class Test3 {


    /**
     * 实现了字符串的反转替换
     * @param originStr
     * @return
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        String s = "hanlibo123";
        String a = null;
        try {
            a = new String(s.getBytes("GB2312"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(a);

        System.out.println();
    }
}
