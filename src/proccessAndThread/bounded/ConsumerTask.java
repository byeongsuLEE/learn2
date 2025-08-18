package proccessAndThread.bounded;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-16
 * 풀이방법
 **/


public class ConsumerTask implements Runnable {

    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[소비 시도]  ?  <- " + queue);
        String data = queue.take();
        log("[소비 완료] " +data + "  ?  <- " + queue);
    }
}
