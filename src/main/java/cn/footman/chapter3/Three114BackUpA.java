package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 20:14
 */
public class Three114BackUpA extends Thread {
    private Three114DBTools dbTools;

    public Three114BackUpA(Three114DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backUpA();
    }
}
