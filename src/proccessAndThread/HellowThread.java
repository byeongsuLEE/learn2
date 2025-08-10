package proccessAndThread;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-10
 * 풀이방법
 **/


public class HellowThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Hello Thread run");
    }
}
