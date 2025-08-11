package proccessAndThread;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 중첩 클래스로 runnable 클래스를 만들어봅시다.
 *
 * 정적 클래스란?
 * 정적 중첩 클래스(Static Nested Class)는 다른 클래스 내부에 static 키워드를 사용하여 선언된 클래스를 말합니다.
 **/


public class InnerRunnableV1 {
    public static void main(String[] args) {
        log("main start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        log("main end");

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log(Thread.currentThread().getName() + ": run() ");
        }
    }


}
