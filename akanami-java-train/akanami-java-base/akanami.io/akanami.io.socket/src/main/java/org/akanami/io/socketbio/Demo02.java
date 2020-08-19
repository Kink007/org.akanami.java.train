package org.akanami.io.socketbio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo02 {
    public static void main(String[] args) {

    }

    static class Server {
        public void start() {
            Thread thread = new Thread(() ->{
                try {
                    ServerSocket serverSocket = new ServerSocket(10012);
                    Socket socket = serverSocket.accept();
                    //socketbio.setTcpNoDelay();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            thread.start();
        }
    }
}
