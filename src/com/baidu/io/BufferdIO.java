package com.baidu.io;

import java.io.*;

/**
 * Created by Administrator on 2017/8/13.
 */
public class BufferdIO {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/iotest/demo.txt");
        BufferedInputStream bin = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        bin.read(bytes);
        fileInputStream.close();

    }
}
