package proccessAndThread.cas;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 * 풀이방법
 **/


public class SyncInteger implements IncrementInteger {
     private int value ;

    @Override
    synchronized public void increment() {
        value++;
    }

    @Override
    synchronized public int get() {
        return value;
    }
}
