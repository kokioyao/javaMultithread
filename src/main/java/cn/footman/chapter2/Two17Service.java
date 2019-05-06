package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 19:32
 */
public class Two17Service {
    public synchronized void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName=  " + Thread.currentThread().getName() + "run beginTime= " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName= " + Thread.currentThread().getName() + "run exceptionTime = " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread b run time= " + System.currentTimeMillis());
        }
    }
}
