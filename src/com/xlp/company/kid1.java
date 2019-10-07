package com.xlp.company;

import java.util.HashMap;
import java.util.Scanner;

public class kid1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuffer sb=new StringBuffer();
        int i=n;
        int k,l,t;
        String m;
        for(int j=1;j<n;j++){
            sb.append("1+");
        }
        sb.append("1");
        System.out.println(sb.toString());
        while(sb.length()>1){
            k=(int)sb.charAt(i);
            l=(int)sb.charAt(i-1);
            t=(k+l);
            m="t";
            sb.replace(i-1,i-1,m);
            i--;
            System.out.println(sb.toString());
        }

    }
}
