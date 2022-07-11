package Study.Week20_24;

import java.io.*;
import java.util.StringTokenizer;
// 오름세
public class Main3745 {
    static int[] arr,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while((str = br.readLine()) != null) {
            int N = Integer.parseInt(str.trim());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N];
            dp[0] = arr[0];
            int len = 1;

            for (int i = 1; i < N; i++) {
                int num = arr[i];

                if (dp[len - 1] < num) {
                    dp[len] = num;
                    len++;
                } else {
                    int start = 0;
                    int end = len;

                    while (start < end) {
                        int mid = (start + end) / 2;

                        if (dp[mid] < num) {
                            start = mid + 1;
                        } else {
                            end = mid;
                        }
                    }
                    dp[start] = num;
                }
            }
            sb.append(len).append('\n');
        }

        System.out.println(sb);
    }
}

