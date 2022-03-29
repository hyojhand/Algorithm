package Study.Week7;

import java.io.*;
import java.util.*;

public class Main16918 {
    static int R,C,N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                if(str.charAt(j) == '.') arr[i][j] = -1;
                else arr[i][j] = 0;
            }
        }

        find();

        System.out.println(sb);

    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void find() {
        int t = 1;

        while(t <= N) {
            if(N == 1) break;

            if(t % 2 == 0) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(arr[i][j] == -1) arr[i][j] = t;
                    }
                }
            }
            else {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(arr[i][j] == t-3) {
                            arr[i][j] = -1;
                            for(int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx >= 0 && ny >= 0 && nx < R && ny < C && arr[nx][ny] != t-3) arr[nx][ny] = -1;
                            }
                        }
                    }
                }
            }
            t++;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == -1) sb.append(".");
                else sb.append("O");
            }
            sb.append('\n');
        }

    }
}
