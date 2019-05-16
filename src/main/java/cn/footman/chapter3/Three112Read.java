package cn.footman.chapter3;

import java.io.PipedInputStream;

/**
 * @author kokio
 * @create 2019-05-15 19:50
 */
public class Three112Read extends Thread {
    private Three112ReadData readData;
    private PipedInputStream inputStream;

    public Three112Read(Three112ReadData readData, PipedInputStream inputStream) {
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        readData.readMethod(inputStream);
    }
}
