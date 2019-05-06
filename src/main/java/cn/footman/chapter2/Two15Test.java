package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 15:20
 */
public class Two15Test {
    public static void main(String[] args) {
        try {
            Two15PublicVar publicVar215 = new Two15PublicVar();
            Two15ThreadA two15ThreadA = new Two15ThreadA(publicVar215);
            two15ThreadA.start();
            Thread.sleep(200);
            publicVar215.getValue();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
