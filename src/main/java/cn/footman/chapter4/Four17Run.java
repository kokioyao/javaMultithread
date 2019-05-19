package cn.footman.chapter4;

/**
 * @author kokio
 * @create 2019-05-17 20:05
 */
public class Four17Run {
    public static void main(String[] args) {
        Four17MyService service = new Four17MyService();

        Four17ThreadA threadA = new Four17ThreadA(service);
        Four17ThreadB threadB = new Four17ThreadB(service);
        threadA.start();
        threadB.start();
    }
}
