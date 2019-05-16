package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 20:14
 */
public class Three114BackUpB extends Thread {
    private Three114DBTools dbTools;

    public Three114BackUpB(Three114DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backUpB();
    }
}
