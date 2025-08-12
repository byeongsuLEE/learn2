package proccessAndThread.yeild;

import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * 풀이방법
 **/


public class YieldMain {
    static final int THREAD_COUNT = 1000;
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }
    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " +
                        i);
                // 1. empty
                //sleep(1); // 2. sleep
                Thread.yield(); // 3. yield
            }
        }
    }
}