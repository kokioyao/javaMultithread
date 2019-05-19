package cn.footman.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kokio
 * @create 2019-05-17 19:58
 */
public class Four17MyService {
    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }
            System.out.println("❤️❤️❤️❤️");
            hasValue = true;
            condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {

        try {
            lock.lock();
            while (!hasValue){
                condition.await();
            }
            System.out.println("🌲🌲🌲🌲");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
