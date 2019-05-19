package cn.footman.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2019-05-17 20:29
 */
public class Four110Myservice {
    public ReentrantLock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();
    public void serviceMethod1(){
        try {
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + "进入方法");
//            condition.await();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
