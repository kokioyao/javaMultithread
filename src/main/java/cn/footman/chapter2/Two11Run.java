package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-04-30 19:29
 */
public class Two11Run {
    public static void main(String[] args) {
        Two11HasSelfPrivateNum hasSelfPrivateNum = new Two11HasSelfPrivateNum();
        Two11ThreadA threadA = new Two11ThreadA(hasSelfPrivateNum);
        threadA.start();
        Two11ThreadB threadB = new Two11ThreadB(hasSelfPrivateNum);
        threadB.start();
    }
}
