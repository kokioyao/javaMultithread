package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-17 20:30
 */
public class Four110Run {
    public static void main(String[] args) throws InterruptedException {
        Four110Myservice myservice = new Four110Myservice();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                myservice.serviceMethod1();
            }
        };

        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(runnable);
        }

        for(int i = 0; i< 10; i++){
            threads[i].start();
        }

        Thread.sleep(2000);
        System.out.println("有线程数" + myservice.lock.getQueueLength() + "正在等待");
    }
}
