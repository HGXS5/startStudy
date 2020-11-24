package com.han.demo8;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Test4 {
    public static void main(String[] args) throws IOException {
        String url = "D:\\han\\src\\com\\han\\demo8\\Test1.java";
        currentDir(url);
    }
    /**
     * 显示当前目录下所有文件的名称
     */
    public static void currentDir(String url){
        File f = new File(url);
        /**
         * 1. listFiles()方法 返回一个抽象路径名数组，该数组表示此抽象路径名表示的目录中的文件
         * 2. isFile()方法 测试此抽象路径名表示的文件是否为普通文件
         *
         */
        for (File file : f.listFiles()) {
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }

    /**
     * 打开多级目录
     * @param url
     */
    public static void showDirectory(String url){
        File f = new File(url);
        walkDirectory(f,0);
    }

    /**
     * 判断是否含有目录，继续打开
     * @param f
     * @param level
     */
    public static void walkDirectory(File f,int level){
        if (f.isDirectory()){
            for (File dir : f.listFiles()) {
                walkDirectory(dir,level+1);
            }
        }
        else{
            for (int i = 0; i < level-1; i++) {
                System.out.println("\t");
            }
            System.out.println(f.getName());
        }
    }

    //Java 7中  使用NIO.2的API
    public static void NIOApITwo(String url) throws IOException {
        /**
         * 1. get(String url)方法 将给定的URL转换为Path对象 （在Paths对象中存在的）
         * 2. walkFileTree(Path start, FileVisitor<? super Path> visitor)方法 走文件树，
         *      该方法不遵循符号链接，可以访问文件树的所有级别；
         *       参数1:起始文件；
         *       参数二：每个文件都要调用的文件访问者；
         * 3. visitFile(T file, BasicFileAttributes attrs)方法 调用目录中的文件
         *      参数1：文件的引用
         *      参数2：文件的基本属性
         *
         * 4. CONTINUE为枚举类FileVisitResult一个成员，从preVisitDirectory方法返回时，还应该访问目录中的条目
         */
        Path initPath = Paths.get(url);
        Files.walkFileTree(initPath,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
