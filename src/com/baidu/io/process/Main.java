package com.baidu.io.process;

import java.io.*;

/**
 * Created by Administrator on 2017/8/9.
 */
public class Main {
    // java执行系统命令
    public static void command(String command) {

        boolean err = false;
        try {
            Process process = new ProcessBuilder(command).start();
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            BufferedReader out = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = error.readLine() )!= null && s.length() != 0){
                System.out.println(s);
            }
            String o;
            while ((o = out.readLine() )!= null && o.length() != 0){
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        command("java");
    }
}
