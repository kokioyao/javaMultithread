package cn.footman.chapter5;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author kokio
 * @create 2019-05-19 19:36
 */
public class Five11MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间是  " + new Date());
    }
}
