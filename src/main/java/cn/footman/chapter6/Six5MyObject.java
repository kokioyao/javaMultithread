package cn.footman.chapter6;

/**
 * @author kokio
 * @create 2019-05-20 14:22
 */
public class Six5MyObject {
    private static Six5MyObject myObject;

    public Six5MyObject() {
    }

    static {
        myObject = new Six5MyObject();
    }

    public static Six5MyObject getInstance(){
        return myObject;
    }
}
