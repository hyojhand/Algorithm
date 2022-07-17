package Study.Week20_24;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열 4
public class Main14002 {
    static int[] arr,dp;
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = 1;
        for(int i = 1; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        int num = max;
        Stack<Integer> stack = new Stack<>();

        for(int i = N-1; i >= 0; i--) {
            if(num == dp[i]) {
                stack.push(arr[i]);
                num--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(max);
        System.out.println(sb);
    }
}

