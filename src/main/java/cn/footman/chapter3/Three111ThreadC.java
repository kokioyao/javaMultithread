package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 18:26
 */
public class Three111ThreadC extends Thread {
    private Three111C c;

    public Three111ThreadC(Three111C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.getValue();
        }
    }
}
