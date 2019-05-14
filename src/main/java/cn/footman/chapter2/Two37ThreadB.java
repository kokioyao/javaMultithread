package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-14 19:21
 */
public class Two37ThreadB extends Thread {
    private Two37Service service;

    public Two37ThreadB(Two37Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}

