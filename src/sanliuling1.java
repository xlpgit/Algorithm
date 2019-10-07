import java.util.Scanner;

public class sanliuling1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[2][2];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int v,vo=0,a,t;
        float l=0;
        for(int i=0;i<arr.length;i++){
            a=arr[i][0];
            t=arr[i][1];
            v=vo+a*t;
            l=(float)(vo*t+0.5*a*t*t);
            vo=v;
        }
        System.out.println(l);
    }
}
