package SWEA.Week9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1767 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int N,min,connect_core;
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int tc = 0;
        while (tc < T) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            min = Integer.MAX_VALUE;
            connect_core = Integer.MIN_VALUE;
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        if(i > 0 && j > 0 && i < N-1 && j < N-1) list.add(new Point(i,j));
                    }
                }
            }

            dfs(0, 0,0);

            tc++;
            sb.append("#").append(tc).append(" ").append(min).append('\n');
        }
        System.out.println(sb);
    }


    public static void dfs(int line, int dept , int connect) {
        if (dept == list.size()) {
            if(connect > connect_core) {
                connect_core = connect;
                min = line;
            } else if (connect == connect_core) {
                min = Math.min(min,line);
            }
            return;
        }

        int x = list.get(dept).x;
        int y = list.get(dept).y;

        for(int k = 0; k < 4; k++) {
            int count = 0;
            int nx = x;
            int ny = y;
            while(true) {
                nx += dx[k];
                ny += dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                if(arr[nx][ny] == 1) {
                    count = 0;
                    break;
                }

                count++;
            }

            nx = x;
            ny = y;
            for(int i = 0; i < count; i++) {
                nx += dx[k];
                ny += dy[k];
                arr[nx][ny] = 1;
            }


            if(count == 0) {
                dfs(line, dept+1, connect);
            } else {
                dfs(line + count, dept+1, connect+1);

                nx = x;
                ny = y;
                for(int i = 0; i < count; i++) {
                    nx += dx[k];
                    ny += dy[k];

                    arr[nx][ny] = 0;
                }
            }

        }

    }

    static class Point {
        int x;
        int y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

}
