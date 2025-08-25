package proccessAndThread.executor.future;

import java.util.List;
import java.util.concurrent.*;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class InvokeAllMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        CallableTask taskA = new CallableTask("task1", 1000);
        CallableTask taskB = new CallableTask("task2", 2000);
        CallableTask taskC = new CallableTask("task3", 3000);

        List<CallableTask> tasks = List.of(taskA, taskB, taskC);
        List<Future<Integer>> futures = es.invokeAll(tasks);
        for (Future<Integer> future : futures) {
             Integer value = future.get();
             log("value = " + value);
        }

        es.shutdown();

    }
}
