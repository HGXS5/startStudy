package com.han.demo8;

import java.io.*;

/**
 * 第一种实现文件拷贝 Java 7 TWR格式，
 * 使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅
 */
public class Test1 {
    private Test1() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                /**
                 * 1. read()方法 从输入流中读取下一个数据字节（InputStream对象中的方法）
                 * 2. write()方法 从指定的字节数组开始将len个字节从offset偏移量写入此输出流
                 *          这里的指定的字节数组是 buffer大小为4096；
                 *          这里的len个字节是指bytesRoRead 在输入流中读取的字节数
                 *          这里的offset（偏移量）为0
                 */
                while ((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }
}
