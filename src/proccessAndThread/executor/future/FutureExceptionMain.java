package proccessAndThread.executor.future;

import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class FutureExceptionMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000);

        try {
            log("future get 호출 시도 future state () " + future.isDone());
            Integer result = future.get();
            log("result value :  " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } catch (ExecutionException e) {
            // 스레드를 실행하고 있을 떄 예외 발생 시 터지는 문제
            log("e = " + e);
            e.getCause();
            log("cause  = " + e.getCause());
        }
        es.shutdown();

    }
    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행 예외 발생 ");
            throw new IllegalStateException("ex");

        }
    }
}
