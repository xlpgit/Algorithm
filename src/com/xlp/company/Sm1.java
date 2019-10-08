package com.xlp.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 实现统计一篇英文文章内每个单词的出现频率，
 * 并返回出现频率最高的前10个单词及其出现次数
 */
public class Sm1 {
    public static void main(String[] args) {

    }
    public static void method(String s){
        HashMap<String,Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        s=s.replace(',',' ');
        s=s.replace('.',' ');
        String[] str=s.split(" ");
        for(int i=0;i<str.length;i++){
            map.put(str[i],1);
        }
        for(int i=0;i<str.length;i++){
            if(map.containsKey(str[i])){
                int count=map.get(i);
                count++;
                map.put(str[i],count);
            }else{
                list.add(str[i]);
            }
        }
        for(int i=0;i<list.size();i++){
            int max=0;
            String maxStr;
            int current=map.get(i);
            if(current>max){
                max=current;
                maxStr=list.get(i);
            }
        }

    }
}
