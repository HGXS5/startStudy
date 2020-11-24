package com.han.demo9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        /**
         * 1. Socket(InetAddress address, int port)构造器 创建一个流套接字，并将其连接到指定IP地址上的指定端口号
         * 2. static InputStream in ：标准输入流（在System类中）
         * 3. nextLine()方法 将此扫描仪前进到前行之外，并返回被跳过的输入（在Scanner对象中）
         */
        Socket client = new Socket("129.211.15.108", 8886);
        Scanner sc = new Scanner(System.in);
        System.out.println("帅逼动一动你的手指：");
        String msg = sc.nextLine();
        sc.close();
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(msg);
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());
        client.close();
    }
}
