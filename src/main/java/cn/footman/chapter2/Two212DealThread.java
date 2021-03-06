package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-11 01:33
 */
public class Two212DealThread implements Runnable {
    public String username;

    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username){
        this.username = username;
    }

    @Override
    public void run() {
        if(username.equals("a")){
            synchronized (lock1){
                try{
                    System.out.println("username = " + username);
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("lock1 -> lock2");
                }
            }
        }

        if(username.equals("b")){
            synchronized (lock2){
                try{
                    System.out.println("username = " + username);
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (lock1){
                    System.out.println("lock2 -> lock1");
                }
            }
        }
    }
}
