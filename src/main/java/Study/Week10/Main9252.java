package Study.Week10;

import java.io.*;
import java.util.Stack;
//LCS2
public class Main9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();
        int len = str.length();
        int len2 = str2.length();

        int[][] dp = new int[len+1][len2+1];
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= len2; j++) {
                if(str.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        int x = len;
        int y = len2;
        while(dp[x][y] != 0) {
            if(str.charAt(x-1) == str2.charAt(y-1)) {
                stack.push(str.charAt(x-1));
                x--;
                y--;
            } else {
                if(dp[x-1][y] > dp[x][y-1]) x--;
                else y--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(dp[len][len2]);
        System.out.println(sb);

        String result = "";
        while(!stack.isEmpty()) {
            char ch = stack.pop();
            result = ch + result;
        }
        System.out.println(result);
    }
}
