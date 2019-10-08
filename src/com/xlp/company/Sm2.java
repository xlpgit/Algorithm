package com.xlp.company;

import java.util.HashSet;

/**
 * 一个无序不重复的整数数组，给一个数值 K，
 * 问有多少对数之和为K？ 有多少对之差为K？
 */
public class Sm2 {
    public static void main(String[] args) {
        int[] arr={3,2,4,1,9};
        method(arr,5);
    }
    public static void method(int[] arr,int k){
        HashSet<Integer> set=new HashSet<>();
        int count1=0;
        int count2=0;
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(set.contains(k-arr[i])){
                count1++;
            }
            if(set.contains(k+arr[i])){
                count2++;
            }
        }
        System.out.println("和为k对数:"+count1/2+" "+"差为k对数:"+count2);

    }
}
