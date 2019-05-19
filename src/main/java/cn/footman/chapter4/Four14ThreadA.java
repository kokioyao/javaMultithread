package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-17 19:37
 */
public class Four14ThreadA extends Thread {
    private Four14MyService service;

    public Four14ThreadA(Four14MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
