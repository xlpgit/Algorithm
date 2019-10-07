import java.util.Scanner;

public class Ks1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        int a,b,max=0,count=0;
        for(int i=0;i<s.length()-1;i++){
            a=ch[i];
            b=ch[i+1];
            if((a^b)==1){
                count+=1;
            }else if((a^b)==0){
                count=0;
            }
            if(count>max){
                max=count;
            }

        }
        int result=max*2-(max-1);
        System.out.println(result);
    }
}
