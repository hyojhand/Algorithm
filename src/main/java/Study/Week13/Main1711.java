package Study.Week13;

import java.io.*;
import java.util.*;
// 직각삼각형
public class Main1711 {
    static int N;
    static long arr[][];
    static Point[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        memo = new Point[3];
        dfs(0,0);
        System.out.println(result);
    }

    static int result = 0;
    static void dfs(int nx,int dept) {
        if(dept == 3) {
            long[] num = new long[3];
            long max = 0;
            int max_idx = 0;
            for(int k = 0; k < 3; k++) {

                num[k] = (memo[k].x-memo[(k+1)%3].x)*(memo[k].x-memo[(k+1)%3].x)+(memo[k].y-memo[(k+1)%3].y)*(memo[k].y-memo[(k+1)%3].y);
//                num[k] = (long) Math.pow(memo[k].x-memo[(k+1)%3].x,2)+ (long) Math.pow(memo[k].y-memo[(k+1)%3].y,2);

                if(max < num[k]) {
                    max = num[k];
                    max_idx = k;
                }
            }

            long sum = 0;
            for(int k = 0; k < 3; k++) {
                if(k == max_idx) continue;
                sum += num[k];
            }

            if(max == sum) result++;
            return;
        }

        if(nx >= N) return;

        memo[dept] = new Point(arr[nx][0], arr[nx][1]);
        dfs(nx+1,dept+1);
        memo[dept] = null;
        dfs(nx+1,dept);
    }

    static class Point {
        long x,y;
        public Point(long x,long y) {
            this.x = x;
            this.y = y;
        }
    }
}
