import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int money=sc.nextInt();
        int count=sc.nextInt();
        int[] arr=new int[count];
        for(int i=0;i<count;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int preprice=0;
        int price=0;
        for(int i=count-1;i>=0;i--){
            preprice=price;
            price+=arr[i];
            if(price>=1000 && preprice<1000 && price/3<money){
                System.out.println(price);
                break;
            }
            if(price>=1000 && price/3>money){
                System.out.println(-1);
            }
        }
    }
    
}
