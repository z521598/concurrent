package com.baidu.io;

import java.io.*;

/**
 * Created by Administrator on 2017/8/7.
 */
public class IOMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // BufferedOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:/iotest/demo.txt"));
        byte[] bytes = "Hello,io".getBytes();
        bufferedOutputStream.write(bytes,0,bytes.length);
        bufferedOutputStream.close();

        //
//        byte[] bytes4Thread = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
//        dataOutputStream.write(100000);
//        dataOutputStream.close();
//        byte[] bytes4Thread = byteArrayOutputStream.toByteArray();
//        System.out.println(bytes4Thread.toString());
//

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(new IOCla("lsq",21));
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        IOCla ioCla = (IOCla) objectInputStream.readObject();
        System.out.println(ioCla);


    }
}
