package proccessAndThread.bounded;

public interface BoundedQueue {
    void put(String data); // 데이터를 생산
    String take();  // 데이터를 가진다.
}
