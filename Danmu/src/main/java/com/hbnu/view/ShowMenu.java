package com.hbnu.view;

import com.hbnu.control.*;
import com.hbnu.net.ReceiveDemo;
import com.hbnu.net.SendDemo;
import com.hbnu.pojo.User;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class ShowMenu {
    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        int code ;
        do{
            System.out.printf("==========主菜单==========\n1.注册\n2.登陆\n3.退出\n ");
            code = sc.nextInt();
            //根据输入数字进入对应子菜单，输入3则推出循环
            switch (code){
                case 1:
                    Logup.reg();
                case 2:
                    Login.checkLogin();
                    break;
                case 3:
                    exit();
            }

        } while(code != 3);
    }


    public static void showMenu(User user){
        System.out.println("==========Menu==========");
        //判断用户类型,进入对应菜单，1为学生，2为老师
        if (user.getType() == 1){
            stuMenu(Integer.parseInt(user.getSno()));
        }else if(user.getType() == 2){
            teachMenu();
        }
    }
    public static void teachMenu() {
        Scanner sc = new Scanner(System.in);
        int code ;
        do{
            System.out.printf("1.查看学生信息 \n2.添加学生信息 \n3.修改学生信息 \n4.删除学生信息 \n5.学生信息导出 \n6.弹幕小工具 \n7.退出\n");
            code = sc.nextInt();
            switch (code) {
                case 1:
                    ShowStuList.showUserList();
                    break;
                case 2:
                    AddStu.addStu();
                    break;
                case 3:
                    UpdateStu.updateStu();
                    break;
                case 4:
                    DeleteStu.deleteStu();
                    break;
                case 5:
                    System.out.println("学生信息导出");
                    ExportInfo.exportUserList();
                    break;
                case 6:
                    System.out.println("弹幕小工具");
                    ReceiveDemo.receiveNsg();
                    break;
            }

        }while(code != 7);
    }
    public static void stuMenu(int id){
        ShowInfo.printInfo(id);

        Scanner sc = new Scanner(System.in);
        int code;
        do{
            System.out.printf("1.查看个人信息 \n2.修改个人信息 \n3.个人信息导出 \n4.弹幕小工具 \n5.退出\n");
            code = sc.nextInt();
            switch (code){
                case 1:
                    ShowInfo.printInfo(id);
                    break;
                case 2:
                    UpdateUser.updateUser(id);
                    break;
                case 3:
                    System.out.println("个人信息导出");
                    ExportInfo.exportUser(id);
                    break;
                case 4:
                    System.out.println("弹幕小工具");
                    //SendMessage.sendMsg();
                    SendDemo.sendMsg();
                    break;
                case 5:
                    break;
            }
        }while(code != 5);
    }
}
