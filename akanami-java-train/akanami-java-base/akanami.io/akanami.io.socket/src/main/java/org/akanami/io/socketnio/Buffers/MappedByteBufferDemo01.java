package org.akanami.io.socketnio.Buffers;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferDemo01 {
    private static final String PATH = "akanami-java-base/akanami.io/akanami.io.socket/src/main/resources/nio/buffer/mappedByteBufferDemo01.txt";

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(PATH, "rw");
        FileChannel randomAccessFileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = randomAccessFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10);

        mappedByteBuffer.putChar('h');
        mappedByteBuffer.putChar('e');
        mappedByteBuffer.putChar('l');
        mappedByteBuffer.putChar('l');
        mappedByteBuffer.putChar('o');

        randomAccessFile.close();
    }
}
