package proccessAndThread;

import org.w3c.dom.css.Counter;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class PracticeThread {
    public static void main(String[] args) {

        Thread thread = new CounterThread();
        thread.start();
    }

    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
