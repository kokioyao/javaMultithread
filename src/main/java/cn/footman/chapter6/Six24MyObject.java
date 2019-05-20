package cn.footman.chapter6;

/**
 * @author kokio
 * @create 2019-05-20 14:09
 */
public class Six24MyObject {
    private volatile static Six24MyObject myObject;

    private Six24MyObject() {
    }

    public static Six24MyObject getInstance(){
        if(myObject == null){
            synchronized (Six24MyObject.class){
                if(myObject == null){
                    myObject = new Six24MyObject();
                }
            }
        }
        return myObject;
    }
}
