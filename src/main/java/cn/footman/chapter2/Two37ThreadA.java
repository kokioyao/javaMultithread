package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-14 19:20
 */
public class Two37ThreadA extends Thread {
    private Two37Service service;

    public Two37ThreadA(Two37Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}
