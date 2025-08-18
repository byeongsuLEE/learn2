package proccessAndThread.bounded;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-16
 * 풀이방법
 **/


public class ProducerTask implements Runnable{

    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {

        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 완료] " + request + " -> " + queue);
    }
}
