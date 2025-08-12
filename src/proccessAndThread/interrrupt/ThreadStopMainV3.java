package proccessAndThread.interrrupt;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * 현재 코드는 작업이 바로 중단이 안되는 코드다.
 * 4초 뒤에 바로 꺼지는게아니라 6초 즉 2초 뒤에 꺼집니다.
 * 개선 코드
 * - interrupt을 이용합시다.
 * 개선 2
 * 앞에 thread.sleep 위 부분의 코드들이 실행된 후 스레드가 반응 했다.
 * 바로 즉각적으로 인터럽트의 상태를 while 문의 조건으로 사용해서 즉각 반응하도록 개선해보자.
 * 이 코드의 문제점
 * - 자원 정리가 되지 않음
 **/


public class ThreadStopMainV3 {

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

            while(!Thread.currentThread().isInterrupted()) {  // 인터럽트 상태 변경
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
