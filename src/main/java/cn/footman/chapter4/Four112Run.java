package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-19 16:43
 */
public class Four112Run {

    public static void main(String[] args) {
        Four112isFair service = new Four112isFair();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        Thread threadA = new Thread(runnable);
        threadA.start();
    }


}
