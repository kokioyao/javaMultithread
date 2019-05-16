package cn.footman.chapter3;

import java.io.PipedOutputStream;

/**
 * @author kokio
 * @create 2019-05-15 19:48
 */
public class Three112Write extends Thread {
    private Three112WriteData writeData;
    private PipedOutputStream outputStream;

    public Three112Write(Three112WriteData writeData, PipedOutputStream outputStream) {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }
}
