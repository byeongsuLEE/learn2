package proccessAndThread.executor.poolsize;

import proccessAndThread.executor.RunnableTask;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;
import static proccessAndThread.executor.ExecutorUtils.printState;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-26
 * 풀이방법
 **/


public class PoolSizeMainV3 {
    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName =  "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es,taskName);
        }

        sleep(3000);
        log("작업 수행 완료 ");
        printState(es);

        sleep(3000);
        log("maximunPoolSize 대기 시간 초과");
        printState(es);


        es.shutdown();
        log("shutdown 완료");
        printState(es);




    }
}
