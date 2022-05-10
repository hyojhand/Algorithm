package Study.Week12;

import java.io.*;
import java.util.StringTokenizer;
// 두배 더하기
public class Main12931 {
    static Point[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Point[1001];
        dp[0] = new Point(0,0);
        dp[1] = new Point(1,0);

        int result = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            result += dp(arr[i]).cnt;
            max = Math.max(max, dp(arr[i]).two);
        }
        result+= max;
        System.out.println(result);
    }

    static Point dp(int num) {
        if(dp[num] != null) return dp[num];

        if(num % 2 == 0) dp[num] = new Point(dp(num / 2).cnt, dp(num/2).two+1);
        else dp[num] = new Point(dp(num-1).cnt +1, dp(num-1).two);

        return dp[num];
    }

    static class Point {
        int cnt,two;
        public Point(int cnt,int two) {
            this.cnt = cnt;
            this.two = two;
        }
    }
}
