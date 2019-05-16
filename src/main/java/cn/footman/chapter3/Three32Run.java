package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-16 19:53
 */
public class Three32Run {
    public static void main(String[] args) {
        try {
            Three32ThreadA threadA = new Three32ThreadA();
            Three32ThreadB threadB = new Three32ThreadB();
            threadA.start();
            threadB.start();
            for (int i = 0; i < 100; i++) {
                Three32Tools.tl.set("Main" + (i + 200));
                System.out.println("Main get Value=" + Three32Tools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
