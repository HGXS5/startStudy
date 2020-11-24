package com.han.demo8;


import java.io.BufferedReader;
import java.io.FileReader;

public class Test3 {
    //工具类中的方法都是静态方法访问的因此将构造器私有化不允许创建对象
    private Test3(){
        throw new AssertionError();
    }

    /**
     * 统计给定文件中字符串的出现次数
     * @param filename 文件名
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String filename,String word){
        int counter = 0;
        /**
         * 1. 构造器FileReader(String fileName):给定要读取的文件名，创建一个新的FilReader
         * 2. 构造器BufferedReader(Reader in)：创建使用默认的输入缓冲区字符输入流
         * 3. readLine()方法 读取一行文本返回String类型 （在BufferedReader中的方法）
         * 4. indexOf(int ch)方法 返回指定字符首次出现在此字符串中的索引
         */
        try(FileReader fr = new FileReader(filename)){
            try(BufferedReader br = new BufferedReader(fr)){
                String line = null;
                while ((line = br.readLine()) != null){
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word))>=0){
                        counter ++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return counter;
    }
}
