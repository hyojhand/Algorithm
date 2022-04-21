package Study.Week10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 다리 만들기 (ArrayList ver)
public class Main2146v2 {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Point>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    list.add(new ArrayList<>());
                    dfs(i,j,idx);
                    idx++;
                }
            }
        }

        for(int i = 0; i < list.size()-1; i++) {
            for(int j = i+1; j < list.size(); j++) {
                for(Point a : list.get(i)) {
                    for(Point b : list.get(j)) {
                        min = Math.min(min, Math.abs(a.x - b.x)+Math.abs(a.y - b.y) - 1);
                    }
                }
            }
        }


        System.out.println(min);
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static void dfs(int x,int y,int idx) {
        arr[x][y] = 2;
        list.get(idx).add(new Point(x,y));
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0&&ny>=0&&nx<N&&ny<N&&arr[nx][ny] == 1) dfs(nx,ny,idx);
        }
    }

    static class Point {
        int x,y;
        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
