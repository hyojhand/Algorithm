package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            Stack<Integer> stack = new Stack<>();
            String str = br.readLine();
            boolean isVPS = true;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                if (isVPS) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            } else {
                sb.append("NO").append('\n');
            }

            T--;
        }

        System.out.println(sb);
    }
}
