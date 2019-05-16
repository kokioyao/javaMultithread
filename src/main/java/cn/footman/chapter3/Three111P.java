package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 18:15
 */
public class Three111P {
    private String lock;

    public Three111P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                while (!Three111ValueObject.value.equals("")){
                    lock.wait();
                }
                String  value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set 的值是 " + value);
                Three111ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
