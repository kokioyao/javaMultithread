package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-19 19:12
 */
public class Four21ThreadB extends Thread  {
    private Four21Service service;

    public Four21ThreadB(Four21Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
