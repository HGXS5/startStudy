package com.han.demo9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoServerNIO {
    private static final int ECHO_SERVER_PORT = 8886;
    private static final int ECHO_SERVER_TIMEOUT = 5000;
    private static final int BUFFER_SIZE = 1024;

    private static ServerSocketChannel serverSocketChannel = null;
    private static Selector selector = null; //多路复用选择器
    private static ByteBuffer buffer = null; //缓冲区

    public static void main(String[] args) {
        init();
        listen();
    }
    private static void init(){
        System.out.println("init执行");
        /**
         * 1. open()方法 打开服务器套接字通道（在ServerSocketChannel对象中）
         * 2. allocate(int capacity)方法 分配一个新的字节缓冲区（在ByteBuffer对象中）
         * 3. socket()方法 检索与此通道关联的服务套接字，返回值ServerSocket（在ServerSocketChannel对象中）
         * 4. bind(SocketAddress endpoint)方法 将ServerSocket绑定到特定地址（IP地址和端口）（在ServerSocket对象中）
         * 5. new InetSocketAddress(int port)构造器 创建一个套接字地址，其中IP地址为通配符地址，端口号为指定值
         * 6. configureBlocking(boolean block)方法 是否调整此通道的阻止模式 （该方法在ServerSocketChannel对象的父类AbstractSelectableChannel中）
         * 7. open()方法 打开选择器 （在Selector对象中）
         * 8. register(Selector sel,int ops)方法 使用给定的选择器注册此通道，并返回选择键。（该方法在SelectableChannel中，是AbstractSelectable的父类）
         * 9. OP_ACCEPT属性 套接字接受操作的操作设置位
         *          使用：假设选择键的兴趣集在选择操作开始时包含OP_ACCEPT。
         *              如果选择器检测到相应的服务器套接字通道已准备好接受另一个连接，或者有待处理的错误，
         *              则它将选择项OP_ACCEPT添加到密钥的就绪集中，并将该密钥添加到其选择密钥集中。
         */
        try {
            serverSocketChannel = ServerSocketChannel.open();
            buffer = ByteBuffer.allocate(BUFFER_SIZE);
//            serverSocketChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
//           serverSocketChannel.socket().bind(new InetSocketAddress("129.211.15.108",ECHO_SERVER_PORT));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void listen(){
        System.out.println("listen执行");
        /**
         * 1. select(long timeout)方法 选择一组键，其相应的通道已准备好进行I/O操作 （在Selector对象中）
         *          参数：
         *              timeout: 如果为正数，则在等待通道准备就绪时最多阻塞超时毫秒，或多或少；
         *                      如果为0，则无限阻塞；
         *                      不能为负；
         *          返回：
         *              准备操作集已更新的键数（可能为零）
         * 2. selectedKeys()方法 返回选择器的选择键集 （在Selector对象中）
         * 3. iterator()方法 返回此集合中元素迭代器 （在接口Set<E>中）
         * 4. hasNext()方法 如果迭代具有更多的元素，则返回true （在Iterator<E>接口中）
         * 5. next()方法 返回迭代中的下一个元素 （在Iterator<E>接口中）
         * 6. remove()方法 从基础集合中移除此迭代器返回的最后一个元素（可选操作）
         */
        while(true){
            try {
                if (selector.select(ECHO_SERVER_TIMEOUT) != 0){
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while(it.hasNext()){
                        SelectionKey key = it.next();
//                        System.out.println("key:"+key);
                        it.remove();
                        handlerKey(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handlerKey(SelectionKey key) throws IOException {
//        System.out.println("handlerKey执行");
        SocketChannel channel = null;
        /**
         * 1. isAcceptable()方法 测试此键的通道是否已准备好接受新的套接字连接 （在SelectionKey对象中）
         * 2. channel()方法 返回为其创建此键的通道 （在SelectionKey对象中）
         * 3. accept()方法 接受与此通道的套接字建立的连接 （在ServerSocketChannel对象中）
         *          返回：
         *              新连接的套接字通道；如果此通道处于非阻塞模式并且没有可用的连接，则为null
         * 4. OP_READ属性 读操作的操作设置位
         *          使用：假设选择键的兴趣集在选择操作开始时包含OP_READ.
         *              如果选择器检测到相应的通道已准备好读取，已到达流的末端，已被远程关闭以进行进一步读取或有待处理的错误，
         *              则它将选择器OP_READ添加到键的就绪操作集中并添加所选键集的键
         * 5. isReadable()方法 测试此键的通道是否已准备好读取 （在SelectionKey对象中）
         * 6. clear()方法 清除此缓冲区。位置设置为零，限制设置为容量，并且标记被丢弃。在使用一些列通道读取或者放置操作填充此缓冲区
         *                  之前，请调用此方法。（在ByteBuffer对象中）
         * 7. read(ByteBuffer dst)方法 从此通道将字节序列读取到给定的缓冲区中
         * 8. flip()方法 翻转此缓冲区，将限制设置为当前位置，然后将该位置设置为零。如果定义了标记，则将其丢弃。
         *                  在执行一系列通道读取或放置操作之后，调用此方法以准备一系列通道写入或相对get操作
         *                  当将数据从一个地方传输到另一个地方时，通常将此方法与紧凑方法结合使用。（在Buffer类中）
         * 9. getRemoteAddress()方法 返回套接字连接到的远程地址。
         */
        try {
            if (key.isAcceptable()){
                ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
                 channel = socketChannel.accept();
                channel.configureBlocking(false);
//                System.out.println("貌似执行是这个位置");
                channel.register(selector, SelectionKey.OP_READ);
            }else if (key.isReadable()){
                channel = (SocketChannel) key.channel();
                buffer.clear();
                if (channel.read(buffer) > 0){
                    buffer.flip();
                    CharBuffer decode = CharsetHelper.decode(buffer);
                    String s = decode.toString();
                    System.out.println("收到" + channel.getRemoteAddress() + "的消息：" + s);
                    channel.write(CharsetHelper.encode(CharBuffer.wrap(s)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (channel != null){
                channel.close();
            }
        }
    }
}
