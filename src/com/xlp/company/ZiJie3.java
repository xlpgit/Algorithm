package com.xlp.company;

import java.util.Scanner;

public class ZiJie3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int min=a[0];
        if(min==1){
            System.out.println(sum(a));
        }else {
            for (int i = 1; i < a.length; i++) {
                if (a[i] == 1) {
                    System.out.println(sum(a));
                } else if (a[i] > 1) {
                    int l = a[i] / 2;
                    int r = a[i] - l;
                    if(l<min){
                        min=l;
                    }
                    if(a[i]/min<min){
                        min=a[i]/min;
                    }
                    System.out.println(sum(a,min));
                }
            }
        }
    }
    public static int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static int sum(int[] arr,int min){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]/min;
        }
        return sum;
    }

}
