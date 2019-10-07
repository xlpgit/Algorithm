package com.xlp.company;

import java.util.Scanner;

public class yitu3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a1[][]=new int[n][m];
        int a2[][]=new int[n][m];
        for(int i=0;i<n;i++){
            a1[i][0]=sc.nextInt();
            a1[i][1]=sc.nextInt();
            a1[i][2]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            a2[i][0]=sc.nextInt();
            a2[i][1]=sc.nextInt();
            a2[i][2]=sc.nextInt();
        }
    }
}
