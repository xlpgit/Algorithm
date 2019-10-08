package com.xlp.company;

import java.util.Scanner;

/**
 * n分解之后的整数的最大值
 */
public class Keda2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            if(n%2!=0){
                int m1=n/2;
                int m2=m1+1;
                System.out.println(m1*m2);
            }else{
                int m=n/2;
                System.out.println(m*m);
            }
        }
    }
}
