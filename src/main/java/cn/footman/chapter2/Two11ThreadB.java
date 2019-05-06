package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-04-30 19:28
 */
public class Two11ThreadB extends Thread {
    private Two11HasSelfPrivateNum numRef;

    public Two11ThreadB(Two11HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
