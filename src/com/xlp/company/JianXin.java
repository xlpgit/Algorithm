package com.xlp.company;

import java.util.Scanner;

public class JianXin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String aStr=sc.nextLine().toLowerCase();
        char[] aChar = aStr.toCharArray();
        String bStr=sc.nextLine().toLowerCase();
        char[] bChar=bStr.toCharArray();
        int count=0;
        int temp=0;
        for(int i=0;i<aChar.length;i++){
            for(int j=0;i<bChar.length;j++){
                if(aChar[i]==bChar[j]){
                    count+=j;
                    temp=j;
                    break;
                }
            }
        }
        count=count+bChar.length-temp-1;
        System.out.println(count);
    }
}
