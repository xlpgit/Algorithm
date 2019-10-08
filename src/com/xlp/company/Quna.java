package com.xlp.company;

import java.util.Scanner;

public class Quna {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println(1);
        }else{
            int[] arr=new int[n+1];
            arr[0]=1;
            arr[n]=1;
            int value;
            for(int i=1;i<arr.length-1;i++){
                value=n*i/fib(i);
                arr[i]=value;
            }
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static int fib(int m){
        if(m==1){
            return 1;
        }
        return m*fib(m-1);
    }
}
