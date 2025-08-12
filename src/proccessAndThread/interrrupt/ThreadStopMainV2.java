package proccessAndThread.interrrupt;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * 현재 코드는 작업이 바로 중단이 안되는 코드다.
 * 4초 뒤에 바로 꺼지는게아니라 6초 즉 2초 뒤에 꺼집니다.
 * 개선 코드
 * interrupt을 이용합시다.
 **/


public class ThreadStopMainV2 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 ="  +  thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            try {
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000);

                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2  = " +  Thread.currentThread().isInterrupted());
                log("interrut message  = " + e.getMessage());
                log("state = "   + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("자원 종료");

        }
    }
}
