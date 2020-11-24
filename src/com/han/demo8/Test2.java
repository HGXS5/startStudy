package com.han.demo8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 第二种实现文件拷贝 第一种实现文件拷贝 Java 7 TWR格式，
 *  * 使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅
 */
public class Test2 {
    private Test2(){
        throw new AssertionError();
    }

    public static void fileCopyNIO(String source, String target)throws IOException {
        try(FileInputStream in = new FileInputStream(source)){
            try(FileOutputStream out = new FileOutputStream(target)){
                /**
                 * 1. getChannel()方法 返回与此文件输入(输出)流关联的唯一FileChannel对象
                 *  （在FileInputStream/FileOutputStream对象中的方法）
                 * 2. allocate()方法 分配一个新的字节缓冲区 （在ByteBuffer对象中的方法）
                 * 3. read()方法 从此通道将字节序列读取到给定的缓冲区中 （FileChannel 对象中的方法）
                 * 4. write()方法 从给定的缓冲区将字节序列写入此通道（fileChannel 对象中的方法）
                 * 5. flip()方法 翻转此缓存区 （在ByteBuffer对象的父类Buffer中的方法）：个人理解就是开启缓存
                 * 6. clear()方法  清除此缓存区 （在ByteBuffer对象中的父类Buffer中的方法）
                 */
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer)!= -1){
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
