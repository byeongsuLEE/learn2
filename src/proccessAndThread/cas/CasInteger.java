package proccessAndThread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 * 풀이방법
 **/


public class CasInteger implements IncrementInteger
{
    AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void increment() {
        atomicInteger.incrementAndGet();

    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
