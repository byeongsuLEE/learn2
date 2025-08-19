package proccessAndThread.cas;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 * 풀이방법
 **/


public class BasicInteger implements IncrementInteger{
    private int value;
    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
