package proccessAndThread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-16
 *
 * Lock condition
 **/


public class BoundedQueueV5 implements BoundedQueue {


    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();


    private final Queue<String> queue = new ArrayDeque<String>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public  void put(String data) {
        lock.lock();
        try{
            while(queue.size() == max){
                log("[put] 큐가 가득 참 , 생산자 대기");
                try {
                    producerCondition.await();
//                    wait(); // runnable -> waiting 락 반납
                    log("[put] 생산자 꺠어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, consumerCondition 호출");
//            notify();  신호 주는거
            consumerCondition.signal();
        }finally {
            lock.unlock();
        }


    }

    @Override
    public String take() {
        lock.lock();
        try {
            while(queue.isEmpty()){
                log("[take] 큐에 데이터가 없음 , 소비자 대기");
                try {
                    consumerCondition.await();
//                    wait(); // runnable -> waiting 락 반납
                    log("[take] 소비자 꺠어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            String data = queue.poll();
            log("[take] 소비자 데이터 획득, producerCondition 호출");
//            notify(); // 대기 스레드, wait -> blocked
             producerCondition.signal();
            return data;

        }finally {
            lock.unlock();
        }


    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
