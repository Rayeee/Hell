package com.hell.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Rayee on 16/7/16.
 */
public class LockThread implements Runnable {

    private Integer key = 0;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            key++;
            System.out.println(Thread.currentThread().getName() + ":" + key);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        LockThread lockThread = new LockThread();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Thread(lockThread));
        }
    }
}
