import java.util.Scanner;


public class yitu2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            System.out.println(fib(a));
        }



    }
    public static int fib(int i){
        if(i==1){
            return 2;
        }
        if(i==7){
            return 7;
        }
        int value=0;
        while(i>2){
            //int v1=fib(i-1)*fib(i+1);
            int v2=1/2*fib(i+1);
            //int max=v1+v2;
            //int min=v1-v2;
            if(value<v2 && value>(-v2)){
                value=(int)Math.sqrt(value);
                return fib(value);
            }
        }
        return 0;
    }
}
