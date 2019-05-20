package cn.footman.chapter6;

/**
 * @author kokio
 * @create 2019-05-20 13:53
 */
public class Six1MyObject {
    //立即加在方式 饿汉模式
    private static Six1MyObject myObject = new Six1MyObject();

    private Six1MyObject(){

    }

    public static Six1MyObject getInstance(){
        //此版本是立即加在
        //不能有其他实例变量
        //getInstance方法没有同步，可能会出现非线程安全问题
        return myObject;
    }
}
