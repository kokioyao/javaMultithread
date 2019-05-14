package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-14 19:18
 */
public class Two37Service {
    private boolean isContinueRun = true;

//    public void runMethod(){
//        while (isContinueRun == true){
//
//        }
//        System.out.println("it's stop");
//    }

    public void runMethod(){
        Object o = new Object();
        while (isContinueRun == true){
            synchronized (o){

            }

        }
        System.out.println("it's stop");
    }

    public void stopMethod(){
        isContinueRun = false;
    }
}
