package proccessAndThread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-24
 * 기존 join으로 결과값을 받아왔지만 Callable를 이용해서 결과값을 가져올 수 있다.
 *
 **/


public class CallableMainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result value =  " + result);
        es.shutdown();

    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("create value = " + value);
            log("CallableI 완료");
            return value;
        }
    }
}
