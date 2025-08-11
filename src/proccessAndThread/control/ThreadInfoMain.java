package proccessAndThread.control;

import proccessAndThread.HellowRunnable;

import static logger.MyLogger.log;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-11
 * 풀이방법
 **/


public class ThreadInfoMain {
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        log("mainThread =  " + thread);
        log("mainThread.getId =  " + thread.getId());
        log("mainThread.getName =  " + thread.getName());
        log("mainThread.getPriority =  " + thread.getPriority());
        log("mainThread.getThreadGroup =  " + thread.getThreadGroup());
        log("mainThread.getState =  " + thread.getState());

        Thread myThread = new Thread(new HellowRunnable() , "myThread");

        log("myThread =  " + myThread);
        log("myThread.getId =  " + myThread.getId());
        log("myThread.getName =  " + myThread.getName());
        log("myThread.getPriority =  " + myThread.getPriority());
        log("myThread.getThreadGroup =  " + myThread.getThreadGroup());
        log("myThread.getState =  " + myThread.getState());
    }
}
