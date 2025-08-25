package proccessAndThread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-23
 * 스레드 로그 출력용
 **/


public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService  ) {
        if(executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize(); // 스레드 풀에서 생성된 스레드의 개수
            int active = poolExecutor.getActiveCount(); // 실제 작업을 하고 있는 스레드 수
            int queuedTask = poolExecutor.getQueue().size(); // 스레드 풀도 생산자 소비자 처럼 작업이 큐에 담긴다. 이 큐에 들어가 있는 작업의 수
            long completedTask = poolExecutor.getCompletedTaskCount(); // 완료된 작업의 수
            log("[pool=" + pool + ", active=" + active + ", queueTasks=" + queuedTask+ ", completedTask=" + completedTask + "]" );
        }else{
            log(executorService);
        }
    }
}
