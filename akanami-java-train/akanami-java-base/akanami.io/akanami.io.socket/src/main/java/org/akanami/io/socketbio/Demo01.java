package org.akanami.io.socketbio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01 {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        System.out.println("Server Start");
        Client client = new Client();
        client.start();
        System.out.println("Client Start");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Server {
        private static void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(10011);
                System.out.println("服务端开始监听");
                Socket socket = serverSocket.accept();
                System.out.println("服务端获取连接，创建接收流");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String s = bufferedReader.readLine();

                System.out.println("Server:" + s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            Thread thread = new Thread(Server::run);
            thread.start();
        }
    }

    static class Client {
        public void start() {
            Thread thread = new Thread(Client::run);
            thread.start();
        }

        private static void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 10011);
                System.out.println("客户端创建连接");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write("hello from client");
                System.out.println("客户端创建发送流，并写入发送信息");
                bufferedWriter.write("\r\n");
                bufferedWriter.flush();
                System.out.println("客户端清空发送流缓冲区");

                //socketbio.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
