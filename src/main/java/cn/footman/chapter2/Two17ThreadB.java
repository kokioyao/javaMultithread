package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 19:36
 */
public class Two17ThreadB extends Thread {
    private Two17Service two17Service;

    public Two17ThreadB(Two17Service two17Service) {
        this.two17Service = two17Service;
    }

    @Override
    public void run() {
        super.run();
        two17Service.testMethod();
    }
}
