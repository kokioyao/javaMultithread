package cn.footman.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author kokio
 * @create 2019-05-15 19:50
 */
public class Three112Run {
    public static void main(String[] args) {
        try {
            Three112WriteData writeData = new Three112WriteData();
            Three112ReadData readData = new Three112ReadData();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream();

            pipedInputStream.connect(pipedOutputStream);


            Three112Read read = new Three112Read(readData, pipedInputStream);
            read.start();
            Thread.sleep(2000);


            Three112Write write = new Three112Write(writeData, pipedOutputStream);
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
