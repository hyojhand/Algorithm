package Study.Week20_24;

import java.io.*;
import java.util.*;
// 가희와 로그파일
public class Main21774 {
    static long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        time = new long[N+1];
        int[] level = new int[N+1];
        int[][] dp = new int[N+1][7];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            time[i] = Long.parseLong(st.nextToken().replaceAll("[-: ]",""));
            level[i] = Integer.parseInt(st.nextToken());

            for(int j = level[i]; j >= 1; j--) {
                dp[i][j] = 1;
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= 6; j++) {
                dp[i][j] += dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), "#");
            long start = Long.parseLong(st.nextToken().replaceAll("[-: ]",""));
            long end = Long.parseLong(st.nextToken().replaceAll("[-: ]",""));
            int lev = Integer.parseInt(st.nextToken());

            int startNum = findStart(1, N+1, start);
            int endNum = findEnd(1, N+1, end);
            int count = dp[endNum-1][lev] - dp[startNum-1][lev];
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    static int findStart(int start, int end, long num) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(num <= time[mid]) end = mid;
            else start = mid +1;
        }
        return end;
    }

    static int findEnd(int start, int end, long num) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(num >= time[mid]) start = mid+1;
            else end = mid;
        }
        return end;
    }
}

