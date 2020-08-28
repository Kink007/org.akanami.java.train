package org.akanami.io.files.outputs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OutputDemo01 {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("outputdemo01.txt"))) {
            writer.write("hello");
            writer.write("world");
            writer.write(System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
