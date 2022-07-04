package Study.Week16;

import java.io.*;
import java.util.StringTokenizer;

// 월드컵
public class Main6987 {
    static int[] win,draw,lose,team1,team2;
    static boolean isOk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        team1 = new int[15];
        team2 = new int[15];
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = i+1; j < 6; j++) {
                team1[cnt] = i;
                team2[cnt] = j;
                cnt++;
            }
        }

        for(int t = 0; t< 4; t++) {
            isOk = false;
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int win_count = 0;
            int draw_count = 0;
            int lose_count = 0;
            for (int i = 0; i < 6; i++) {
                win[i] = Integer.parseInt(st.nextToken());
                win_count+=win[i];
                draw[i] = Integer.parseInt(st.nextToken());
                draw_count+= draw[i];
                lose[i] = Integer.parseInt(st.nextToken());
                lose_count += lose[i];
            }

            if(win_count+draw_count+lose_count != 30) {
                sb.append(0).append(" ");
            } else {
                dfs(0);

                if(isOk) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        if(isOk) return;

        if(idx == 15) {
            isOk = true;
            return;
        }

        int a = team1[idx];
        int b = team2[idx];

        if(win[a]>0 && lose[b]>0) {
            win[a]--;
            lose[b]--;
            dfs(idx+1);
            win[a]++;
            lose[b]++;
        }

        if(draw[a]>0 && draw[b]>0) {
            draw[a]--;
            draw[b]--;
            dfs(idx+1);
            draw[a]++;
            draw[b]++;
        }

        if(lose[a]>0 && win[b]>0) {
            lose[a]--;
            win[b]--;
            dfs(idx+1);
            lose[a]++;
            win[b]++;
        }
    }
}
