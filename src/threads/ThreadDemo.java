package threads;

/**
 * 多线程（2个）实现1+2+...+100
 * 两个线程分别实现求和
 */
public class ThreadDemo implements Runnable{

    int start,end,sum,number;

    public ThreadDemo(int start, int end, int sum, int number) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.number = number;
    }

    @Override
    public void run() {
        for(int i=start;i<=end;i++){
           sum+=i;
        }
        System.out.println("Thread."+number+"executes sum from"+start
                +"to"+end+"is"+sum);
    }

    public static void main(String[] args) {
        int start=1;
        int end=100;
        int sum=0;
        int threads=2;
        Thread thread1=new Thread(new ThreadDemo(start,end,sum,1));
        thread1.start();
        Thread thread2=new Thread(new ThreadDemo(start,end,sum,2));
        thread2.start();

    }

}
