package SWEA.Week2;

import java.io.*;
import java.util.Stack;

public class Calculator2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 0;
        while (tc < 10) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            Stack<Character> temp = new Stack<>();
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);

                if (ch - '0' >= 0) {
                    stack.push(ch);
                } else {
                    if (temp.isEmpty()) {
                        temp.push(ch);
                    } else {
                        if (ch == '+') {
                            while (!temp.isEmpty()) {
                                stack.push(temp.pop());
                            }
                            temp.push(ch);
                        } else if (ch == '*') {
                            temp.push(ch);
                        }
                    }
                }

            }
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }

            String change = "";
            int stack_size = stack.size();
            for (int i = 0; i < stack_size; i++) {
                change = stack.pop() + change;
            }


            Stack<Integer> number = new Stack<>();
            int sum = 0;
            for (int i = 0; i < change.length(); i++) {
                char ch2 = change.charAt(i);

                if (ch2 - '0' >= 0) {
                    number.push(ch2 - '0');
                } else {
                    int num1 = number.pop();
                    int num2 = number.pop();
                    switch (ch2) {
                        case '+':
                            sum = num1 + num2;
                            break;
                        case '*':
                            sum = num1 * num2;
                            break;
                    }
                    number.push(sum);
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(number.peek()).append('\n');
        }
        System.out.println(sb);

    }
}
