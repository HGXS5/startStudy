package com.han.demo16;

import java.io.*;

public class fileDivide {
    public static void main(String[] args) throws IOException {
        readAndWriter();
    }
    /**
     * 要求：将一个文档均分成两部分
     * 过程：
     *  1. 读取文档，放入一个集合里面
     *  2. 根据集合长度，判断需要获取的索引
     *  3. 将分别获取的索引写入两个文件中
     */
    //读取文档信息
    public static void readAndWriter() throws IOException {
        File file = new File("D:\\han\\src\\com\\han\\demo16\\1.txt");
        File file2 = new File("D:\\han\\src\\com\\han\\demo16\\2.txt");
        if (file != null){
            file.createNewFile();
        }
        if (file2 != null){
            file2.createNewFile();
        }
        //获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        String line = "";//保存每次读取一行的内容

        while((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();// 表示换行
        }

        bufferedWriter.flush();// 清空缓冲区
        bufferedReader.close();
        bufferedWriter.close();
    }
}
