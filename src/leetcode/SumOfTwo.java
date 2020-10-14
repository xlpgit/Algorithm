package leetcode;

import sun.jvm.hotspot.memory.Generation;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwo {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int result[]=twoSum2(nums,target);
        System.out.println(Arrays.toString(result));
    }
    /**
     * 法一：进行遍历
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 创建哈希表，对每一个x，先查询哈希表中是否存在target-x，若存在，直接返回；将x插入到哈希表中，可保证不与自己匹配。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
