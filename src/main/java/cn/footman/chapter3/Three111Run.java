package cn.footman.chapter3;

/**
 * @author kokio
 * @create 2019-05-15 18:28
 */
public class Three111Run {
    public static void main(String[] args) {
        String lock = new String("");
        Three111P three111P = new Three111P(lock);
        Three111C three111C = new Three111C(lock);
        Three111ThreadP three111ThreadP = new Three111ThreadP(three111P);
        Three111ThreadC three111ThreadC = new Three111ThreadC(three111C);
        three111ThreadP.start();
        three111ThreadC.start();

    }
}
