package com.xlp.company;

import java.util.Scanner;

/**
 * 身高从左到右进行排序，最少可以分为几组
 *eg：2 1 3 2可以分为两组
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int j=1;
        int group=1;
        while(j<n){
            int k=j+1;

        }
    }
}
