package com.xlp.company;

import java.util.HashMap;
import java.util.Scanner;

public class QiAn {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0;
        String gr,sr,br,qr,wr,r="";
        int g,s,b,q,w;
        if(sc.next().contains("a")){
            r="错误输入";
        }else{
            n=sc.nextInt();
        }

        int min=0;
        int max=100000;
        HashMap<Integer,String> map=new HashMap<>();
        map.put(0,"零");
        map.put(1,"一");
        map.put(2,"二");
        map.put(3,"三");
        map.put(4,"四");
        map.put(5,"五");
        map.put(6,"六");
        map.put(7,"七");
        map.put(8,"八");
        map.put(9,"九");
        map.put(10,"十");
        map.put(100,"百");
        map.put(1000,"千");
        map.put(10000,"万");
        if(n>min && n<max){
           if(n/10<0){
               r=map.get(n);
           }else if(n/10>0 && n/100<0){
               s=n/10;
               g=n%10;
               sr=map.get(s);
               gr=map.get(g);
               r=sr+"十"+gr;
           }else if(n/100>0 && n/1000<0){
               b=n/100;
               s=n%100/10;
               g=n%100%10;
               br=map.get(b);
               sr=map.get(s);
               gr=map.get(g);
               r=br+"百"+sr+"十"+gr;
           }else if(n/1000>0 && n/10000<0){
               q=n/1000;
               b=n%1000/100;
               s=n%1000%100/10;
               g=n%1000%100%10;
               qr=map.get(q);
               br=map.get(b);
               sr=map.get(s);
               gr=map.get(g);
               r=qr+"千"+br+"百"+sr+"十"+gr;
           }else if(n/10000>0 && n/100000<0){
               w=n/10000;
               q=n%10000/1000;
               b=n%10000%1000/100;
               s=n%10000%1000%100/10;
               g=n%10000%1000%100%10;
               wr=map.get(w);
               qr=map.get(q);
               br=map.get(b);
               sr=map.get(s);
               gr=map.get(g);
               r=wr+"万"+qr+"千"+br+"百"+sr+"十"+gr;
           }

        }else{
            r="错误输入";
        }
        System.out.println(r);

    }

}
