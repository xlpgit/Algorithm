package dxm;

import java.util.Scanner;

public class dxm1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        int i=1;
        int count=0;
        int maxIndex=(n-1)/2;
        int j=0;
        while(2*i+1<=n){
            a[i]--;
            a[2*i]--;
            a[2*i+1]--;
            if(a[i]==0 && (i+1)<=maxIndex){
                i++;
            }
            if (a[maxIndex] <= 0 && a[2*maxIndex] <=0 && a[2*maxIndex+1]<=0) {
                i++;
                break;
            }
            j++;
            count=j;
        }
        System.out.println(count);
       for(int k=1;k<=n;k++){
           if(a[k]>0){
               count+=a[k];
           }
       }
        System.out.println(count);

    }
}
