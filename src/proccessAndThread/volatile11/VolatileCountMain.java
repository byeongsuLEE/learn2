package proccessAndThread.volatile11;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-13
 * 풀이방법
 **/


public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread t1 = new Thread(myTask, " work");
        t1.start();

        sleep(1000);

        myTask.flag=false;
        log("flag = "  + myTask.flag + ", count = " + myTask.count + " in main");
    }

    static class MyTask implements Runnable {

        boolean flag =true;
        long count ;

        @Override
        public void run() {
            while(flag){
                count++;
                if(count %100_000_000 == 0){
                    log("flag = "  + flag +  ", count = " + count + " in while() ");
                }
            }
            log("flag = "  + flag +  ", count = " + count + " 종료 ");
        }
    }
}
