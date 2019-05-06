package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 19:40
 */
public class Two17Test {
    public static void main(String[] args) {
        try {
            Two17Service two17Service = new Two17Service();
            Two17ThreadA two17ThreadA = new Two17ThreadA(two17Service);
            two17ThreadA.setName("a");
            two17ThreadA.start();
            Thread.sleep(500);
            Two17ThreadB two17ThreadB = new Two17ThreadB(two17Service);
            two17ThreadB.setName("b");
            two17ThreadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
