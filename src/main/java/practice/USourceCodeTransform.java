package practice;

import java.io.*;

/**
 * USourceCodeTransform class
 *
 * @author Soarkey
 * @date 2018/2/21
 */
public class USourceCodeTransform {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("D://a.txt")))));
            out = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(new File("D://a.html")))));
            String line = in.readLine();
            out.write("<html>\n");
            out.write("<body>\n");
            // body
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
                line.replaceAll("&", "&amp;");
                line.replaceAll(" ", "&nbsp;");
                line.replaceAll("<", "&lt;");
                line.replaceAll(">", "&gt;");
                int loc1 = line.lastIndexOf("//");
                int loc2 = line.lastIndexOf("\"");
                if (loc1 != -1 && loc2 != -1 && loc1 > loc2) {
                    String s1 = line.substring(0, loc1);
                    String s2 = line.substring(loc1);
                    s2 = "<font color=green>" + s2 + "</font>";
                    line = s1 + s2;
                } else {
                    int start = -1;
                    int end = -1;
                    boolean isNote = true;
                    for (int i = 0; i < line.length(); i++) {
                        if ('\"' == line.charAt(i)){
                            if (start == -1){
                                start = i;
                            } else {
                                end = i;
//                                if (loc1 > )
                            }

                        }
                    }
                }

            }
            out.write("</body>\n");
            out.write("</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
