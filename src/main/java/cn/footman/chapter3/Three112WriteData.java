package cn.footman.chapter3;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author kokio
 * @create 2019-05-15 19:35
 */
public class Three112WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 200; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
