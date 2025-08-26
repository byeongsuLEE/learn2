package proccessAndThread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static logger.MyLogger.log;
import static proccessAndThread.executor.ExecutorUtils.printState;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTasks", 100_000)); //100초 대기
        printState(es);
        log("== shutdown 시작");
        shutdownAndAwaitTermination(es);
        log("== shutdown 종료");


    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown(); // 논 블로킹 , 새로운 작업을 받지 않고 큐에 대기하거나 처리중인 작업을 처리한다. 이후 풀의 스레드를 종료한다.

        try {
            // 이미 대기중인 작업들을 모듀 완료 할 때가지 10초 기다린다.
            if(!es.awaitTermination(10, TimeUnit.SECONDS)){

                //  작업이 10초 동안 끝나지 않을 때
                log(" 서비스 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow();

                //작업이 취소될 떄 까지 대기한다.
                if(!es.awaitTermination(10, TimeUnit.SECONDS)){
                    log("서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
