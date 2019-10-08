package com.xlp.company;

import java.util.Scanner;

public class TongCheng3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[100000000];
        int i=0;
        while(sc.hasNextInt()){
            arr[i]=sc.nextInt();
            i++;
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j]>arr[j+1]){
                System.out.println(j);
                break;
            }
        }
    }
}
