import java.util.Scanner;


public class baidu2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//
        int m=sc.nextInt();//
        int k=n-m;//
        int[][] arr1=new int[m][2];
        int[][] arr2=new int[k][3];
        for(int i=0;i<m;i++){
            arr1[i][0]=sc.nextInt();
            arr1[i][1]=sc.nextInt();
        }
        for(int i=0;i<k;i++){
            arr2[i][0]=sc.nextInt();
            arr2[i][1]=sc.nextInt();
            arr2[i][2]=sc.nextInt();
        }


    }
}
