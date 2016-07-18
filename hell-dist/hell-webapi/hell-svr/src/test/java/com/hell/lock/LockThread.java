package com.hell.lock;

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
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        for(int i = 0;i<1000;i++){
            new Thread(lockThread).start();
        }
    }
}
