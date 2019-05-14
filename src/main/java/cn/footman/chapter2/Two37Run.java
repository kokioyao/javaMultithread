package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-14 19:22
 */
public class Two37Run {
    public static void main(String[] args) {
        try {
            Two37Service service = new Two37Service();
            Two37ThreadA threadA = new Two37ThreadA(service);
            threadA.start();
            Thread.sleep(1000);
            Two37ThreadB threadB = new Two37ThreadB(service);
            threadB.start();
            System.out.println("已经发送停止指令");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
