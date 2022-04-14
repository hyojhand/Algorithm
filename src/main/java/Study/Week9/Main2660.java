package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 회장뽑기
public class Main2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int INF = 999999;
        int[][] arr = new int[N+1][N+1];
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j && arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        int[] member = new int[N+1];
        int score = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(i != j) cnt = Math.max(cnt, arr[i][j]);
            }
            member[i] = cnt;

            if(cnt < score) {
                score = cnt;
                count = 1;
            } else if(cnt == score) count++;

        }
        sb.append(score).append(" ").append(count).append('\n');

        int temp = 0;
        for(int i = 1; i <= N; i++) {
            if(member[i] == score) {
                sb.append(i).append(" ");
                temp++;
            }
            if(temp == count) break;
        }

        System.out.println(sb);

    }
}

