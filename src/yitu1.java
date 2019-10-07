import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 思路：打算把值以及值出现的次数用hashmap存储，其中键为数值，
 * 值为出现的次数，比较出现次数的多少确定排列顺序。可是现在卡
 * 在了怎么获得map的值。
 */
public class yitu1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        int key=0;
        int value=0;
        for(int i=0;i<n;i++){
            key=sc.nextInt();
            if(map.containsKey(key)){
                map.put(key,++value);
            }else{
                map.put(key,1);
            }
        }
        System.out.println(map.values());


    }
}
