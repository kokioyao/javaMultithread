package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 15:19
 */
public class Two15ThreadA extends Thread {
    private Two15PublicVar publicVar215;

    public Two15ThreadA(Two15PublicVar publicVar215) {
        this.publicVar215 = publicVar215;
    }

    @Override
    public void run() {
        super.run();
        publicVar215.setValue("B","BB");
    }
}
