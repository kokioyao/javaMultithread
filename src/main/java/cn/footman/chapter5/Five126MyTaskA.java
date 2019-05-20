package cn.footman.chapter5;

import java.util.TimerTask;

/**
 * @author kokio
 * @create 2019-05-19 20:13
 */
public class Five126MyTaskA extends TimerTask {
    private int i;

    public Five126MyTaskA(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(" 第" + i + "没有被cancel");
    }
}
