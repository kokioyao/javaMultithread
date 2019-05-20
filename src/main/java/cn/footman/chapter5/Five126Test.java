package cn.footman.chapter5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author kokio
 * @create 2019-05-19 20:14
 */
public class Five126Test {
    public static void main(String[] args) {
        int i = 0;
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();

        while (true){
            i++;
            Timer timer = new Timer();
            Five126MyTaskA myTaskA = new Five126MyTaskA(i);
            timer.schedule(myTaskA,time);
            timer.cancel();
        }
    }
}
