package threads;

/**
 * 多线程（2个）实现1+2+...+100
 * 两个线程交互实现求和
 */

public class PCTest {
    public volatile int sum = 0;//内存可见
    public volatile int top = 1;


    public void add() {
        synchronized (this) {
            sum = sum + top;
            top++;
        }
    }

    class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            while (top <= 100) {
                add();
               // System.out.println(name);
            }


        }
    }

    public static void main(String[] args) {

        PCTest test = new PCTest();
        test.run();
    }

    public void run() {
        Thread thread1 = new Thread(new Task("thread-1"));
        Thread thread2 = new Thread(new Task("thread-2"));
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sum=" + sum);
        System.out.println("top=" + top);
    }

}
