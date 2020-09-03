package org.akanami.io.socketnio.Buffers;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for(int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2 + 1);
        }

        System.out.println(intBuffer);

        intBuffer.flip();

        System.out.println(intBuffer);

        for(int i = 0; i < intBuffer.capacity(); i++) {
            System.out.println(intBuffer.get());
        }
    }
}
