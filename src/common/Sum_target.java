package common;

import java.util.HashMap;

/**
 * 给定一数组，找出数组中和为某个数k的两个数的下标
 * 思路：利用hashmap，其中key用数值，value用下标，找包含 目标值-当前值
 */
public class Sum_target {
    public static void main(String[] args) {
        int[] array=new int[]{1,8,6,2,3,4};
        int k=5;
        System.out.println(sum_target(array,k));
    }

    private static String sum_target(int[] array, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        //int[] result=new int[];
        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
            if(map.containsKey(k-array[i])){
                map2.put(map.get(k-array[i]),i);
                //return new int[]{map.get(k-array[i]),i};
                /*System.out.println(i);
                System.out.println(map.get(k-array[i]));*/
            }
        }
        return map2.toString();

    }

}
