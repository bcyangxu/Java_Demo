package com.hbnu.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveDemo {
    public static void receiveNsg(){

        try {
            DatagramSocket ds = new DatagramSocket(10086);
            InetAddress i = InetAddress.getLocalHost();
            System.out.println("当前ip："+ i.getHostAddress());
            //System.out.println("当前ip："+ds.getLocalAddress());
            int count = 0;      //弹幕数量
            while(true) {

                if (count > 1000) break;

                byte[] bys = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bys, bys.length);
                ds.receive(dp);
                String data = new String(dp.getData(),0,dp.getLength(),"utf-8");

                System.out.println(dp.getAddress()+":"+data);
                count++;
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
