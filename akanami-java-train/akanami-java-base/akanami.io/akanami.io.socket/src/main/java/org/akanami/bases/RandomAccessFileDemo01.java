package org.akanami.bases;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo01 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
            file.writeUTF("hello");
            file.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
