package Study.Week7;

import java.io.*;
import java.util.*;

public class Main2234 {
    static boolean[][] check;
    static String[][] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int[][] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        check = new boolean[N][M];
        num = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(st.nextToken()))));
            }
        }

        bfs();

        int union_count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M && num[i][j] != num[nx][ny]) {
                        union_count = Math.max(union_count, map.get(num[i][j]) + map.get(num[nx][ny]));
                    }
                }
            }
        }
        sb.append(union_count);

        System.out.println(sb);

    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int max_count = 0;
    public static void bfs() {
        Queue<Point> que = new LinkedList<>();

        int level = 0;
        int count;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                count = 0;
                if(!check[i][j]) {
                    check[i][j] = true;
                    level++;
                    que.offer(new Point(i,j));
                    num[i][j] = level;

                    while(!que.isEmpty()) {
                        Point p = que.poll();
                        int x = p.x;
                        int y = p.y;
                        count++;

                        for(int k = 0; k < 4; k++) {
                            if(arr[x][y].charAt(k)-'0' == 0) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if(!check[nx][ny]) {
                                    check[nx][ny] = true;
                                    que.offer(new Point(nx,ny));
                                    num[nx][ny] = level;
                                }
                            }
                        }
                    }
                    max_count = Math.max(max_count, count);
                    map.put(level,count);
                }

            }
        }

        sb.append(level).append('\n');
        sb.append(max_count).append('\n');

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
