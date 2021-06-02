package newcoder.simulate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Board class
 *
 * @author Soarkey
 * @date 2021/3/18
 */
public class Board {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while(in.hasNextInt()){
            int n = in.nextInt();
            in.nextLine();
            String board =  in.nextLine();
            char[] bc = board.toCharArray();

            int ones = 0;
            int zeros = 0;
            for(int i=0; i<n; ++i){
                if(bc[i] == '0')
                    ++zeros;
                else
                    ++ones;
            }

            int ans = Integer.MAX_VALUE;
            int leftOnes = 0;
            int leftZeros = 0;
            ans = Math.min(ans, zeros);
            for(int i=0; i<n; ++i){
                if(bc[i] == '1'){
                    ++leftOnes;
                } else {
                    ++leftZeros;
                }
                ans = Math.min(ans, leftZeros + (ones - leftOnes));
            }
            ans = Math.min(ans, ones);
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
