package proccessAndThread.interrrupt;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * 현재 코드는 작업이 바로 중단이 안되는 코드다.
 * 4초 뒤에 바로 꺼지는게아니라 6초 즉 2초 뒤에 꺼집니다.
 **/


public class ThreadStopMainV1 {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask , "work");
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runflag = flase");
        myTask.runFlag=false;
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;
        @Override
        public void run() {
            while(runFlag){
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");

        }
    }
}
