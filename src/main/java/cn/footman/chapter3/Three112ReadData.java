package cn.footman.chapter3;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author kokio
 * @create 2019-05-15 19:40
 */
public class Three112ReadData {
    public void readMethod(PipedInputStream input){
        try {
            System.out.println(" read : ");
            byte[] byteArrays = new byte[20];
            int readLength = input.read(byteArrays);
            while (readLength != -1){
                String newData = new String(byteArrays, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArrays);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
