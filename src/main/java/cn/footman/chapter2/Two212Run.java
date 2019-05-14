package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-11 01:36
 */
public class Two212Run {
    public static void main(String[] args) {
        try {
            Two212DealThread two212DealThread = new Two212DealThread();
            two212DealThread.setFlag("a");
            Thread t1 = new Thread(two212DealThread);
            t1.start();

            Thread.sleep(100);
            two212DealThread.setFlag("b");

            Thread t2 = new Thread(two212DealThread);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
