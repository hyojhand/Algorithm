package Study.Week20_24;

import java.io.*;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열 2, 3
public class Main12015 {
    static int[] arr,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = arr[0];
        int result = 1;

        for(int i = 1; i < N; i++) {
            int num = arr[i];

            if(dp[result-1] < num) {
                dp[result] = num;
                result++;
            } else {
                int start = 0;
                int end = result;

                while(start < end) {
                    int mid = (start+end)/2;

                    if(dp[mid] < num) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                dp[start] = num;
            }
        }

        System.out.println(result);
    }
}
