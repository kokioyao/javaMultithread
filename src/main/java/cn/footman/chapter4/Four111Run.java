package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-19 16:23
 */
public class Four111Run {
    public static void main(String[] args) throws InterruptedException {
        Four111Service service = new Four111Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.start();
        Thread.sleep(500);
        System.out.println(service.lock.hasQueuedThread(threadA));
        System.out.println(service.lock.hasQueuedThread(threadB));
        System.out.println(service.lock.hasQueuedThreads());

    }
}
