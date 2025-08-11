package proccessAndThread;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class PracticeThread3 {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {
            for (int i = 1; true; i++) {
                log(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread-A");
        thread.start();

        Thread thread2 = new Thread(()-> {
            for (int i = 1; true; i++) {
                log(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread-B");
        thread2.start();
    }

}
