package proccessAndThread.executor.reject;

import proccessAndThread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-26
 * CallerRunsPolicy : 스레드의 작업을 실행할 수 없다면 요청 스레드에게 작업을 시켜버린다.
 * main 스레드가 run()을 실행하여 작업을 실행한다.
 **/


public class RejectMainV3 {
    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));

    }
}
