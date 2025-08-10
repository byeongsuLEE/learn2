package proccessAndThread;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-10
 * 풀이방법
 **/


public class HellowRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+ ": main() start");
        HellowRunnable runnable = new HellowRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(Thread.currentThread().getName()+ ": main() end");
    }
}
