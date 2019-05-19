package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-17 20:04
 */
public class Four17ThreadB extends Thread {
    private Four17MyService service;

    public Four17ThreadB(Four17MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            service.get();

        }
    }
}
