package proccessAndThread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-16
 * blocking queue 즉시 반환
 * - 대기하지 않고 false와 null 반환
 **/


public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);

    }

    @Override
    public  void put(String data) {
        boolean offer = queue.offer(data);
        log("저장 시도 결과 = " + offer);

    }

    @Override
    public String take() {
        String poll = queue.poll();
        return poll;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
