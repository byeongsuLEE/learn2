package proccessAndThread.executor.poolsize;

import proccessAndThread.executor.RunnableTask;

import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;
import static proccessAndThread.executor.ExecutorUtils.printState;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class PoolSizeMainV1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);
        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es ,"task1");
//
        es.execute(new RunnableTask("task2"));
        printState(es ,"task2");

        es.execute(new RunnableTask("task3"));
        printState(es ,"task3");

        es.execute(new RunnableTask("task4"));
        printState(es ,"task4");

        es.execute(new RunnableTask("task5"));
        printState(es ,"task5");

        es.execute(new RunnableTask("task6"));
        printState(es ,"task6");

        try{

            es.execute(new RunnableTask("task7"));
            printState(es ,"task7");
        }catch (RejectedExecutionException e){
           log("task7 실행 거절 예외 발생 " + e );
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
