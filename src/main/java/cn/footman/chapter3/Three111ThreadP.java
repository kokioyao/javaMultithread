package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 18:26
 */
public class Three111ThreadP extends Thread {
    private Three111P p;

    public Three111ThreadP(Three111P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
