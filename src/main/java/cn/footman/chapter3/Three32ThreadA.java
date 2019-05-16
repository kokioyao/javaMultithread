package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-16 19:50
 */
public class Three32ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for(int i = 0; i < 100; i++){
                Three32Tools.tl.set("ThreadA " + (i + 1));
                System.out.println("ThreadA get Value=" + Three32Tools.tl.get());
                Thread.sleep(200);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
