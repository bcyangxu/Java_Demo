package com.hbnu.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class SendDemo {
    public static void sendMsg(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标ip地址：");
        String toIP = sc.next();
        System.out.println("现在你可以发弹幕了，输入”exit;“退出");
        try {
            DatagramSocket ds = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            String line = null;
            int count = 0;
            while((line = br.readLine()) != null){
                if (line.equals("exit;") || count > 100){
                    break;
                }

                byte[] data = line.getBytes();
                DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getByName(toIP),10086);

                ds.send(dp);
                count++;
            }

            ds.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
