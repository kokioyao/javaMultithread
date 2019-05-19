package cn.footman.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2019-05-19 17:56
 */
public class Four116Run {
    public volatile static int nextPrintWho = 1;

    private static ReentrantLock lock = new ReentrantLock();
    private final static Condition conditionA = lock.newCondition();
    private final static Condition conditionB = lock.newCondition();
    private final static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 1) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("threada " + (i + 1));
                    }
                    nextPrintWho = 2;
                    //B全部唤醒
                    conditionB.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 2) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("threadb " + (i + 1));
                    }
                    nextPrintWho = 3;
                    //B全部唤醒
                    conditionC.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (nextPrintWho != 3) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println("threadc " + (i + 1));
                    }
                    nextPrintWho = 1;
                    //B全部唤醒
                    conditionA.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] aArrays = new Thread[5];
        Thread[] bArrays = new Thread[5];
        Thread[] cArrays = new Thread[5];

        for(int i = 0; i< 5; i++){
            aArrays[i] = new Thread(threadA);
            bArrays[i] = new Thread(threadB);
            cArrays[i] = new Thread(threadC);

            aArrays[i].start();
            bArrays[i].start();
            cArrays[i].start();

        }

    }
}
