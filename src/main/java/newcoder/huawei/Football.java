package newcoder.huawei;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Football class
 *
 * @author Soarkey
 * @date 2021/3/31
 */
public class Football {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        // 用26长度先保存队伍
        Team[] team = new Team[26];
        while (in.hasNext()) {
            String[] line = in.nextLine().split(" ");
            // 队伍 a-b
            String[] t = line[0].split("-");
            // 得分 x:y
            String[] s = line[1].split(":");
            // String转为int
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            if (x > y) {
                // a队胜
                x = 3;
                y = 0;
            } else if (x == y) {
                // 平
                x = 1;
                y = 1;
            } else {
                // b队胜
                x = 0;
                y = 3;
            }
            // t[0].charAt(0) - 'a' 代表a队在数组中的下标
            char a = t[0].charAt(0);
            // t[1].charAt(0) - 'a' 代表b队在数组中的下标
            char b = t[1].charAt(0);

            team[a - 'a'] = team[a - 'a'] == null ? new Team(a, 0) : team[a - 'a'];
            team[a - 'a'].score += x;

            team[b - 'a'] = team[b - 'a'] == null ? new Team(b, 0) : team[b - 'a'];
            team[b - 'a'].score += y;
        }

        StringBuilder builder = new StringBuilder();
        // 按照得分和队名进行排序
        Arrays.sort(team, (a, b) -> {
            if (a == null || b == null) {
                return -1;
            }
            if (a.score != b.score) {
                return b.score - a.score;
            } else {
                return a.name - b.name;
            }
        });
        // 输出结果
        for (int i = 0; i < 26; ++i) {
            if (team[i] != null) {
                builder.append(team[i].name + " " + team[i].score + ",");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        out.println(builder);

        in.close();
        out.close();
    }

    /**
     * 队伍类
     */
    static class Team {
        // 队伍名称
        char name;
        // 累积得分
        int score;

        Team(char name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
