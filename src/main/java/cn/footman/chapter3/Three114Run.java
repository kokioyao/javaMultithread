package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 20:16
 */
public class Three114Run {
    public static void main(String[] args) {
        Three114DBTools dbTools = new Three114DBTools();
        for(int i = 0; i < 20 ; i++){
            Three114BackUpA backUpA = new Three114BackUpA(dbTools);
            backUpA.start();
            Three114BackUpB backUpB = new Three114BackUpB(dbTools);
            backUpB.start();
        }

    }
}
