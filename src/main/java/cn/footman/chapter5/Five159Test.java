package cn.footman.chapter5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kokio
 * @create 2019-05-20 13:38
 */
public class Five159Test {
    static class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("begin time " + new Date());
            System.out.println("  end time " + new Date());

        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        System.out.println("现在执行时间：" + new Date());
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.SECOND,instance.get(Calendar.SECOND) - 20);
        Date time = instance.getTime();
        System.out.println("计划执行时间" + time);
        Timer timer = new Timer();
        timer.schedule(myTask,time,2000);
    }
}
