package cn.footman.chapter5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author kokio
 * @create 2019-05-19 19:37
 */
public class Five11Test1 {
    public static void main(String[] args) {
        System.out.println("当前时间是 " + new Date());
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,10);
        Date time = instance.getTime();

        Five11MyTask myTask = new Five11MyTask();
        Timer timer = new Timer();

        timer.schedule(myTask,time);
    }
}
