package common;

/**
 * 求10的阶乘，用递归和非递归方式实现
 */
public class Factorial {
    public static void main(String[] args) {
        int n=10;
        System.out.println(mulRecursion(n));
    }

    //非递归方式实现
    private static int mul(int n) {
        int sum=1;
        for(int i=n;i>0;i--){
            sum*=i;
        }
        return sum;
    }

    //递归方式实现
    private static int mulRecursion(int n){
        int sum;
        if(n==1){
            return 1;
        }
        return n*mulRecursion(n-1);
    }


}
