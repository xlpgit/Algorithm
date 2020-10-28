package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Palindrome {
    public static void main(String[] args) {
        String s="babad";
        String sub=longPalindrome(s);
        System.out.println(sub);
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longPalindrome(String s){
        int len=s.length();
        if(len<2){
            return s;
        }
        int max=1;
        int begin=0;
        //dp[i][j]是否为回文串
        boolean[][] dp=new boolean[len][len];
        char[] chars=s.toCharArray();
        //初始化
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        /**首尾字符一样，并且子串是回文串，整体是回文串；首尾字符一样，若子串不是回文串，整体不是回文串
         * s[i]=s[j]&&dp[i+1][j-1]，边界条件是i+1到j-1不构成区间，即(j-1)-(i+1)+1<2,j-i<3,j-i+1<4,即j到i的距离小于4，
         * 子串 s[i..j] 的长度等于2或者等于3的时候，只需判断首尾字符是否相等即可。
         * **/
        for(int j=1;j<len;j++){
           for(int i=0;i<j;i++){
               if(chars[i]!=chars[j]){
                   dp[i][j]=false;
               }else{
                   if(j-i<3){
                       dp[i][j]=true;
                   }else{
                       dp[i][j]=dp[i+1][j-1];
                   }
               }
               //记录回文子串的长度和起始位置，通过截取字符串返回回文串
               if(dp[i][j]==true&&j-i+1>max){
                   max=j-i+1;
                   begin=i;
               }
           }

        }
        return s.substring(begin,begin+max);
    }
}
