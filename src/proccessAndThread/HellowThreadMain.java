package proccessAndThread;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-10
 * 풀이방법
 **/


public class HellowThreadMain {
    public static void main(String[] args) {
        HellowThread hellowThread = new HellowThread();
        System.out.println(Thread.currentThread().getName() + "main() start");
        System.out.println(Thread.currentThread().getName() + "start () 호출 전 ");

        hellowThread.start();

        System.out.println(Thread.currentThread().getName() + "start () 호출 후 ");
        System.out.println(Thread.currentThread().getName() + "main() end");
    }
}
