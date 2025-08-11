package proccessAndThread;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class PracticeThread2 {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            for (int i = 1; i <= 5; i++) {
                log(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"counter");
        thread.start();
    }

}
