package jvm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * ReturnAddressTest class
 *
 * @author Soarkey
 * @date 2021/4/24
 */
public class ReturnAddressTest {
    public ReturnAddressTest() {

    }

    public boolean methodBoolean() {
        return false;
    }

    public byte methodByte() {
        return 0;
    }

    public short methodShort() {
        return 0;
    }


    public char methodChar() {
        return 0;
    }

    public int methodInt() {
        return 0;
    }

    public long methodLong() {
        return 0;
    }

    public float methodFloat() {
        return 0;
    }

    public double methodDouble() {
        return 0;
    }

    public Integer methodInteger() {
        return 0;
    }

    public String methodString() {
        return "";
    }

    public Date methodDate() {
        return new Date();
    }

    public void showVoid() {

    }

    static {
        int i = 10;
    }


    public void method2() {
        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        File file;
        FileReader fr = new FileReader("demo.txt");
        char[] cbuf = new char[1024];
        int len;
        while ((len = fr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        fr.close();
    }
}
