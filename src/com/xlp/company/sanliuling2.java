package com.xlp.company;

import java.util.Scanner;


//求6个连续的和最大
public class sanliuling2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[]arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        float sum=0;
        int j=1;
        //不够m个数的时候就相加
        while(j<=m){
            sum=(float)(sum+arr[j]);
            j++;
        }
        float temp=0;
        for(int i=1;i<=n-m;i++){
            if(sum<temp){
                sum=temp;
            }else{
                temp=sum-arr[i]+arr[i+m];
            }
        }
        System.out.println(sum/m);
    }
}
