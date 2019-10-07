package com.xlp.company;

import java.util.Scanner;

/**
 * 题目：java实现，caps键和shift+字母键使得大小进行切换的键使用次数最少，
 * 比如：AaAAAA最少切换次数为8
 * 思路：根据字母的ASCII码来判断是否为大写字母，若当前要输入的字母为大写字母且下一位是
 * 小写字母，使用shift键；若当前要输入的字母为大写字母，且下一位仍是大写字母
 * 用cpas键，直到遇到小写字母结束。
 * m
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char c;
        char[] chars=new char[n];
        String s;
        s=sc.next();
        System.out.println(s);
        for(int i=0;i<n;i++){
            chars[i]=s.charAt(i);

        }
        int i=0;
        while (i<n){
            //判断该字母为大写；
            if(chars[i]>='A' && chars[i]<='Z'){

            }
        }
    }
}
