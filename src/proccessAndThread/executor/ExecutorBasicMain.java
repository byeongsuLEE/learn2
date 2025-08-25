package proccessAndThread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;
import static proccessAndThread.executor.ExecutorUtils.*;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-23
 * 풀이방법
 **/


public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2,2,0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태 == " );
        printState(es);

        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));
        log("== 작업 수행 중 == " );
        printState(es);

        sleep(3000);
        log("작업 수행 완료");
        printState(es);

        es.shutdown();
        log("셧다운");
        printState(es);
    }
}
