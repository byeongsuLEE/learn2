package proccessAndThread.executor.future;

import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * cancel(false): future 상태를 취소 상태로 변경하고 실행중인 작업은 중단하지 않는다.
 * cancel(ture): future 상태를 취소 상태로 변경하고 thread interrupt 호출하여 실행 중인 작업을 다 중단함
 **/


public class FutureCancelMain {
    private static boolean mayInterruptIfRunning = true ;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<String> future = es.submit(new MyTask());
        log("Future state: " + future.isDone());
        log("Future state: " + future.isCancelled());

        sleep(3000);
        log("future cancel( " + mayInterruptIfRunning + " ) 호출 ");
        boolean cancel = future.cancel(mayInterruptIfRunning);
        log(" cancel( " + mayInterruptIfRunning + ") result : " + cancel );


        // 결과 확인

        try {
            log("Future result : " + future.get());
        } catch (CancellationException e) {
            log("Future은 이미 취소 되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();

    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중" + i);
                    Thread.sleep(1000);

                }


            } catch (InterruptedException e) {
                log("인터럽트 발생");
                return "Interrupted";
            }


            return "completed";

        }
    }
}
