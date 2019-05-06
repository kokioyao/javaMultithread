package cn.footman.chapter2;

/**
 * @author kokio
 * @create 2019-05-06 15:13
 */
public class Two15PublicVar {
    public String username = "A";
    public String password = "AA";

    public synchronized void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name = " + Thread.currentThread().getName() +
                    " username " + username + " password " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void getValue() {
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() +
                " username " + username + " password " + password);
    }
}
