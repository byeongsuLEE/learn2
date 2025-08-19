package proccessAndThread.cas;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 * 풀이방법
 **/


public class VolatileInteger implements IncrementInteger {
    volatile private int value ;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
