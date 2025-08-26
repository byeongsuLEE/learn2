package proccessAndThread.executor.reject;

import proccessAndThread.executor.RunnableTask;

import java.util.concurrent.*;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-26
 * 풀이방법
 **/


public class RejectMainV1 {
    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        executor.submit(new RunnableTask("task1"));
        try{
            executor.submit(new RunnableTask("task2"));
        }catch (RejectedExecutionException e){
            log("요청 초과");
            log(e);
        }
        executor.shutdown();
    }
}
