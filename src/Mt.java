import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个数组，两个数的和一定，找出这两个数并存储，出现重复的就存两遍
 */
public class Mt {
    public static void main(String[] args) {
        int[] a={1,3,2,1,4,3,2};
        String s=method(a,4);
        System.out.println(s);

    }
    public static String method(int[] arr,int target){
        int i=0;
        int j=arr.length-1;
        Arrays.sort(arr);
        List<KV> list=new ArrayList<>();
        while(i<=j){
            if(arr[i]+arr[j]==target){

                list.add(new KV(arr[i],arr[j]));
                i++;
                j--;
            }
            else if(arr[i]+arr[j]<target){
                i++;
            }
            else {
                j--;
            }
        }
        return list.toString();
    }
}
class KV{
    private  int k;
    private  int v;

    public KV(int k, int v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public String toString() {
        return k+","+v;
    }
}
