package cn.footman.chapter6;

/**
 * @author kokio
 * @create 2019-05-20 14:18
 */
public class Six3MyObject {
    private static class MyObjectHandler{
        private static Six3MyObject myObject = new Six3MyObject();
    }
    private Six3MyObject() {
    }

    public static Six3MyObject getInstance(){
        return MyObjectHandler.myObject;
    }
}

