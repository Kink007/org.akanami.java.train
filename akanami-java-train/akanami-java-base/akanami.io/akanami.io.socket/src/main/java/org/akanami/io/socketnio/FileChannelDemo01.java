package org.akanami.io.socketnio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelDemo01 {
    public static void main(String[] args) {
        Path currentPath = Paths.get(".");
        System.out.println("currentPath:" + currentPath.toAbsolutePath());

        //IDE Debug的时候取相对路径 应该是从根目录开始取
        Path txtPath = Paths.get("akanami-java-base/akanami.io/akanami.io.socket/target/classes/nio/FileChannelDemo01.txt");
        System.out.println("txtPath:" + txtPath.toAbsolutePath());

        try {
            ByteBuffer buff = ByteBuffer.allocate(1024);
            FileChannel fileChannel = FileChannel.open(txtPath);

            while(fileChannel.read(buff) > 0 ) {
                buff.flip();  //调用flip 会设置 pos的位置
                while(buff.hasRemaining()) {
                    System.out.println("byte:" + buff.get());
                }
                //System.out.println("buff:" + buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
