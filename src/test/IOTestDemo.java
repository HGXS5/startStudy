package test;

import com.han.demo8.Test1;
import com.han.demo8.Test2;
import com.han.demo8.Test3;

import java.io.*;

public class IOTestDemo {
    static String a = "D:\\han\\src\\a.txt";
    static String b = "D:\\han\\src\\com\\han\\b.txt";
    public static void main(String[] args) {

//            Test1.fileCopy("D:\\han\\src\\a.txt","D:\\han\\src\\com\\han\\b.txt");
//            Test2.fileCopyNIO("D:\\han\\src\\a.txt","D:\\han\\src\\com\\han\\b.txt");
       int i = Test3.countWordInFile("D:\\han\\src\\a.txt", "f");
        System.out.println(i);


    }
}
