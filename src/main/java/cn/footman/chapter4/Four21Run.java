package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-19 19:12
 */
public class Four21Run {
    public static void main(String[] args) {
        Four21Service service = new Four21Service();
        Four21ThreadA threadA = new Four21ThreadA(service);
        threadA.start();
        Four21ThreadB threadB = new Four21ThreadB(service);
        threadB.start();
    }
}
