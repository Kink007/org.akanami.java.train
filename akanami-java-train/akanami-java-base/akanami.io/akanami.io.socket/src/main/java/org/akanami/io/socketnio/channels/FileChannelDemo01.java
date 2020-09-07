package org.akanami.io.socketnio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo01 {
    private static final String PATH = "akanami-java-base/akanami.io/akanami.io.socket/src/main/resources/nio/channels/fileChannelDemo01.txt";
    private static final String TARGET_PATH = "akanami-java-base/akanami.io/akanami.io.socket/src/main/resources/nio/channels/fileChannelDemo02.txt";

    public static void main(String[] args) throws Exception {
//        writeDemo();
//        readDemo();
        //readDemo1();
        copyDemo();
    }

    static void writeDemo() throws Exception {
        String str = "hello world 123";

        FileOutputStream output = new FileOutputStream(PATH);
        FileChannel fileChannel = output.getChannel();

        //ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        output.close();
    }

    static void readDemo() throws Exception {
        FileInputStream input = new FileInputStream(PATH);
        FileChannel channel = input.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        channel.read(byteBuffer);

        byteBuffer.flip();
        int limit = byteBuffer.limit();

        //byte[] buff = new byte[limit];
        //byteBuffer.get(buff, 0, buff.length);
        byte[] buff = byteBuffer.array();

        String s = new String(buff);
        System.out.println(s);

        input.close();
    }

    static void readDemo1() throws Exception {
        File file = new File(PATH);
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        channel.read(byteBuffer);

        byteBuffer.flip();

        byte[] array = byteBuffer.array();
        String s = new String(array);
        System.out.println(s);

        inputStream.close();
    }

    static void copyDemo() throws Exception {
        File srcFile = new File(PATH);
        File tarFile = new File(TARGET_PATH);

        FileInputStream input = new FileInputStream(srcFile);
        FileOutputStream output = new FileOutputStream(tarFile);

        FileChannel inputChannel = input.getChannel();
        FileChannel outputChannel = output.getChannel();

        outputChannel.transferFrom(inputChannel, 0, (int)srcFile.length() );

        input.close();
        output.close();
    }
}
