package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 20:10
 */
public class Three114DBTools {
    private volatile boolean prevIsA = false;

    public synchronized void backUpA(){
        try {
            while (prevIsA == true){
                wait();
            }
            for(int i = 0 ;i < 5; i++){
                System.out.println("✨✨✨✨✨✨");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void backUpB(){
        try {
            while (prevIsA == false){
                wait();
            }
            for(int i = 0; i< 5 ; i++){
                System.out.println("🕯️🕯️🕯️🕯️🕯️🕯️");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
