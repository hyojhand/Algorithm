package Study.Week20_24;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열 5
public class Main14003 {
    static int[] arr,dp,dept;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dept = new int[N];
        dept[0] = 1;

        dp = new int[N];
        dp[0] = arr[0];
        int result = 1;

        for(int i = 1; i < N; i++) {
            int num = arr[i];
            if(dp[result-1] == num) continue;

            if(dp[result-1] < num) {
                dp[result] = num;
                result++;
                dept[i] = result;
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
                dept[i] = start+1;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int val = result;
        for(int i = N-1; i >= 0; i--) {
            if(dept[i] == val) {
                stack.push(arr[i]);
                val--;
            }

            if(val == 0) break;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(result);
        System.out.println(sb);
    }
}

