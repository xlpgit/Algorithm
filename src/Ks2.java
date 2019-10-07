
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ks2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] big=s.split("\\,");
        String nstr=big[0];
        int n=Integer.parseInt(nstr);
        String mid=big[1];
        String[] split=mid.split("\\.");
        String endstr=split[3];
        int endnum=Integer.parseInt(endstr);
        List list=new ArrayList<String>();
        for(int i=0;i<n;i++){
            if(endnum<254 && endnum%2==0){
                endnum+=2;
            }else if(endnum<255 && endnum%2==1){
                endnum++;
            }
            list.add("'"+split[0]+"."+split[1]+"."+split[2]+"."+endnum+"'");
        }
        System.out.println(list.toString());

    }
}
