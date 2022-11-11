package com.hbnu.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class ReceiveDemo {

    public static void receiveNsg(){
        DatagramSocket ds;

        try {
             ds = new DatagramSocket(10086);
             ds.setSoTimeout(6000);     //设置超时时间，单位ms，测试环境6s
            InetAddress i = InetAddress.getLocalHost();
            System.out.println("当前ip："+ i.getHostAddress());
            //System.out.println("当前ip："+ds.getLocalAddress());
            int count = 0;      //弹幕数量

            while(true) {

                if (count > 1000) break;

                byte[] bys = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bys, bys.length);
                try {
                    ds.receive(dp);
                } catch (IOException ex) {
                    System.out.println("6s未接收到弹幕，自动退出");
                    break;
                }
                String data = new String(dp.getData(),0,dp.getLength(),"utf-8");
                System.out.println(dp.getAddress()+":"+data);
                count++;
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ds.close();

    }
}
