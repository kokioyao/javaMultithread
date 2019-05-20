package cn.footman.chapter6;

/**
 * @author kokio
 * @create 2019-05-20 13:57
 */
public class Six2MyObject {
    private static Six2MyObject myObject;

    private Six2MyObject(){

    }

    public synchronized static Six2MyObject getInstance(){
        if(myObject == null){
            myObject = new Six2MyObject();
        }
        return myObject;
    }
}
