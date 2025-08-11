package proccessAndThread.control;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunnable(), "myRunnable");
        log("myThread.state1 : " + thread.getState());
        log("myThread start()");
        thread.start();
        Thread.sleep(1000);
         log("myThread.state3     : " + thread.getState());
        Thread.sleep(4000);
         log("myThread.state4     : " + thread.getState());

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 : " + Thread.currentThread().getState());
                log("sleep() start");

                Thread.sleep(3000);
                log("myThread.state3 : " + Thread.currentThread().getState());

                log("sleep end");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
