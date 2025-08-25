package proccessAndThread.executor.future;

import java.util.concurrent.Callable;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class CallableTask implements Callable<Integer> {
    private final String name;
    private int sleepMs = 1000;

    public CallableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public Integer call() throws Exception {
        log(name + " 실행 ");
        sleep(sleepMs);
        log(name + " 완료 ");
        return sleepMs;
    }
}
