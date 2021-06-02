package practice;

import java.io.*;

/**
 * FinishedBefore class
 *
 * @author Soarkey
 * @date 2018/11/20
 */
public class FinishedBefore {

    public static void main(String[] args) {
        try {
            File inFile = new File("test.java");
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(inFile);
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            File outFile = new File("test.html");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            OutputStreamWriter outStreamWriter =
                    new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outStreamWriter);
            outStreamWriter.write("<html>\n");
            outStreamWriter.write("<body>\n");
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                tempString = tempString.replaceAll("&", "&amp;");
                tempString = tempString.replaceAll(" ", "&nbsp;");
                tempString = tempString.replaceAll("<", "&lt;");
                tempString = tempString.replaceAll(">", "&gt;");
                int index1 = tempString.lastIndexOf("//");
                int index2 = tempString.indexOf("\"");
                if (index1 != -1 && index2 == -1) {
                    String s1 = tempString.substring(0, index1);
                    String s2 = tempString.substring(index1);
                    s2 = "<font color=green>" + s2 + "</font>";
                    tempString = s1 + s2;
                } else if (index1 != -1 && index2 != -1) {
                    int startMark = -1, endMark = -1;
                    boolean isNote = true;
                    for (int i = 0; i < tempString.length(); i++) {
                        if ('\"' == tempString.charAt(i)) {
                            if (startMark == -1) {
                                startMark = i;
                            } else {
                                endMark = i;
                                if (index1 > startMark && index1 < endMark) {
                                    isNote = false;
                                    break;
                                } else {
                                    startMark = -1;
                                    endMark = -1;
                                }
                            }
                        }
                    }
                    if (isNote == true) {
                        String s1 = tempString.substring(0, index1);
                        String s2 = tempString.substring(index1);
                        s2 = "<font color=green>" + s2 + "</font>";
                        tempString = s1 + s2;
                    }
                }
                tempString = tempString.replaceAll("\"", "&quot;");
                tempString = tempString.replaceAll("\t",
                        "&nbsp;&nbsp;&nbsp;&nbsp;");
                tempString = tempString.replaceAll("&nbsp;public&nbsp;",
                        "&nbsp;<b>public</b>&nbsp;");
                tempString = tempString.replaceAll("&nbsp;class&nbsp;",
                        "&nbsp;<b>class</b>&nbsp;");
                tempString = tempString.replaceAll("&nbsp;static&nbsp;",
                        "&nbsp;<b>static</b>&nbsp;");
                tempString = tempString.replaceAll("&nbsp;void&nbsp;",
                        "&nbsp;<b>void</b>&nbsp;");
                outStreamWriter.write(tempString + "<br/>" + "\r\n");
            }
            outStreamWriter.write("\n</body>\n");
            outStreamWriter.write("</html>\n");
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}