package Study.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main10157ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[C][R];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int x = 0;
        int y = 0;
        int idx = 1;
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        if(K > R*C) {
            sb.append(0);
        }
        else {
            for(int i = 0; i < R*C; i++) {
                if(idx == K) break;
                arr[x][y] = idx++;

                int nx = x + dx[cnt%4];
                int ny = y + dy[cnt%4];
                if(nx < 0 || ny < 0 || nx >= C || ny >= R || arr[nx][ny] != 0) {
                    cnt++;
                }

                x += dx[cnt%4];
                y += dy[cnt%4];

            }

            sb.append(x+1).append(" ").append(y+1);
        }
        System.out.println(sb);
    }
}
