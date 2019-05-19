package cn.footman.chapter4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2019-05-19 16:40
 */
public class Four112isFair {
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("默认使用的是公平锁么？ " + lock.isFair());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
