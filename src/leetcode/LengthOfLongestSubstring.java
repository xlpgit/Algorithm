package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcab";
        System.out.println(subLength(s));
    }

    /**
     * 滑动窗口的思路，左右指针，刚开始左指针是第一个元素，右指针移动，直到遇到重复元素，记录长度，左指针右移一位
     *
     * @param s
     * @return
     */
    public static int subLength(String s) {
        Set<Character> set = new HashSet<>();
        //右指针默认为-1
        int right = -1;
        int result = 0;
        //左指针从下标为0开始
        for (int i = 0; i < s.length(); i++) {
            //左指针右移时，移除一个字符
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;
    }
}
