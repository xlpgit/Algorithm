package com.xlp.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 验证用户名、密码和手机号
 */
public class Keda1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        String password=sc.nextLine();
        String phone=sc.nextLine();
        check(name,password,phone);
    }
    public static void check(String name,String password,String phone){
        HashSet<String> set=new HashSet<>();
        set.add("zhangsan");
        set.add("lisi");
        if(set.contains(name)){
            System.out.println("该用户已存在");
            return;
        }
        if(password.length()<8 || password.length()>11 ||
                !password.matches("/^1-8|a-z|A-Z")){
            System.out.println("密码格式错误");
            return;
        }
        if(phone.length()!=11 || phone.charAt(0)!='1'){
            System.out.println("请输入正确的手机号码");
            return;
        }
        System.out.println("注册成功");
    }
}
