package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-04-30 19:29
 */
public class Run1 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        threadA.start();
        ThreadB threadB = new ThreadB(hasSelfPrivateNum);
        threadB.start();
    }
}
