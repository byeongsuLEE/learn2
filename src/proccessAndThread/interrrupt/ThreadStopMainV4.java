package proccessAndThread.interrrupt;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * Thread.interrupted() : 인터럽트가 걸리면 true 된 후 false로 되돌림
 * 위의 함수를 이용해서 자원 관리 시 중지가 안되도록 할 수 있다.
 **/


public class ThreadStopMainV4 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();
        sleep(100);
        log("작업 중단 지시 interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 ="  +  thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {

            while(!Thread.interrupted()) {  // 인터럽트 상태 변경
                log("작업중");
            }
            log("work 스레드 인터럽트 상태2  = " +  Thread.currentThread().isInterrupted());
            log("자원 정리");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log("인터럽트 상태3 =  " + Thread.currentThread().isInterrupted());
            }
            log("자원 종료");

        }
    }
}
