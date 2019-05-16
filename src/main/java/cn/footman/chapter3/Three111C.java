package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 18:25
 */
public class Three111C {
    private String lock;

    public Three111C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while(Three111ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get 的值为 " + Three111ValueObject.value);
                Three111ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
