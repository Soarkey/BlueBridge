package other;

import java.io.*;

/**
 * ReadSelf class
 *
 * @author Soarkey
 * @date 2018/2/21
 */
public class ReadSelf {
    public static void main(String args[]) {
        try {
            //open the file
            FileInputStream fstream = new FileInputStream("E:\\学习资源汇总\\蓝桥\\code\\src\\other\\ReadSelf.java");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            //read data line by line from the file
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            fstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}