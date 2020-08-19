package org.akanami.io.socketnio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo01 {

    static final String HOST = "127.0.0.1";
    static final int PORT = 10013;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Server {
        ServerSocketChannel socketChannel;
        Selector selector;

        public void run() {
            SocketAddress addr = InetSocketAddress.createUnresolved(HOST, PORT);
            try {
                socketChannel = ServerSocketChannel.open();
                socketChannel.socket().setReuseAddress(true);
                socketChannel.configureBlocking(false); //设置为非阻塞模式，必须设置此值

                selector = Selector.open();
                socketChannel.register(selector, SelectionKey.OP_ACCEPT);

                System.out.println("注册完成");
                while(true) {
                    System.out.println("开始循环");
                    if(selector.select() > 0) {
                        System.out.println("获取Selector");
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();

                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();

                            if (key.isAcceptable()) {

                            }
                        }
                    }
                    else {
                        System.out.println("未获取到连接");
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            Thread thread = new Thread(() -> {
                this.run();
            });
            thread.start();
        }
    }

    static class Client {
        public void run() {
            try {
                Socket socket = new Socket();
                SocketAddress addr = InetSocketAddress.createUnresolved(HOST, PORT);
                socket.connect(addr);
                OutputStream outputStream = socket.getOutputStream();
                while(true) {
                    byte[] buff = { 0x01, 0x02, 0x03, 0x04};
                    outputStream.write(buff);

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void start() {
            Thread thread = new Thread(() -> {
                this.run();
            });
            thread.start();
        }
    }
}
