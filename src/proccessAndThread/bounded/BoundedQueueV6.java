package proccessAndThread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-16
 * blocking queue
 * v5 버전에서 처럼 직접 구현하는게 아니라 이미 잘 만들어진 것이 있다. 가져다 써보자.
 **/


public class BoundedQueueV6 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6(int max) {
        this.queue = new ArrayBlockingQueue<>(max);

    }

    @Override
    public  void put(String data) {
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
