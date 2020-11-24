package com.han.demo9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    //端口
    private static final int EHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        /**
         * 1. ServerSocket(int port)构造器 创建绑定指定端口的服务器套接字
         * 2. accept()方法 监听与此套接字建立的连接并接受它（在ServerSocket对象中）
         * 3. Thread(Runnable target)构造器 分配一个新的Thread对象
         * 4. start()方法 使该方程开始执行；Java虚拟机将调用此线程的run方法
         * 5. getInputStream()方法 返回此套接字的输入流 （在Socket对象中）
         * 6. InputStreamReader(InputStream in)构造器 创建一个使用默认字符集的InputStreamReader对象
         * 7. BufferedReader(Reader in) 构造器 创建使用默认大小的输入缓冲区的缓冲字符输入流、
         * 8. PrintWriter(OutputStream out)构造器 从现有的OutputStream创建一个新的PrintWriter，而无需自动刷新。
         * 9. getOutputStream()方法 返回此套接字的输出流（在Socket对象中）
         * 10. getInetAddress()方法 返回套接字连接到的地址
         */
        try(ServerSocket server = new ServerSocket(EHO_SERVER_PORT)){
            System.out.println("服务器已经启动。。。。");
            while(true){
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable{
        public Socket client;
        public ClientHandler(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter pw = new PrintWriter(client.getOutputStream())){
                String msg = br.readLine();
                System.out.println("收到"+client.getInetAddress()+"发送的："+msg);
                pw.println(msg);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
