package Study.Week2;

import java.io.*;
import java.util.Stack;

public class Main17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        boolean isOpen = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                isOpen = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
                continue;
            } else if (ch == '>') {
                isOpen = false;
                sb.append(">");
                continue;
            }

            if (isOpen) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
