package proccessAndThread;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class ManyThreadMain {
    public static void main(String[] args) {
        log("main start");
        HellowRunnable hellowRunnable = new HellowRunnable();
        Thread thread = new Thread(hellowRunnable);
        thread.start();
        Thread thread1 = new Thread(hellowRunnable);
        thread1.start();
        Thread thread2 = new Thread(hellowRunnable);
        thread2.start();
        log("main end");
    }

}
