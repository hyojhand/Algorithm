package SWEA.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tcase = 0;
        while(tcase < 10) {
            int num = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isbreak = false;

            for(int i = 0; i < num; i++) {
                char ch = str.charAt(i);

                if(ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                    stack.push(ch);
                }
                else {
                    switch (ch) {
                        case ')':
                            if(stack.peek() == '(') {
                                stack.pop();
                            }
                            else {
                                isbreak = true;
                            }
                            break;
                        case ']':
                            if(stack.peek() == '[') {
                                stack.pop();
                            }
                            else {
                                isbreak = true;
                            }
                            break;
                        case '}':
                            if(stack.peek() == '{') {
                                stack.pop();
                            }
                            else {
                                isbreak = true;
                            }
                            break;
                        case '>':
                            if(stack.peek() == '<') {
                                stack.pop();
                            }
                            else {
                                isbreak = true;
                            }
                            break;
                    }
                }

                if(isbreak) break;

            }

            tcase++;
            sb.append("#").append(tcase).append(" ");
            if(stack.isEmpty()) {
                if(isbreak) {
                    sb.append(0).append('\n');
                }
                else {
                    sb.append(1).append('\n');
                }
            }
            else {
                sb.append(0).append('\n');
            }

        }

        System.out.println(sb);

    }
}
