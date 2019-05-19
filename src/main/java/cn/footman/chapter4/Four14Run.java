package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-17 19:38
 */
public class Four14Run {
    public static void main(String[] args) {
        try {
            Four14MyService service = new Four14MyService();

            Four14ThreadA threadA = new Four14ThreadA(service);
            threadA.start();

            Thread.sleep(3000);
            service.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
