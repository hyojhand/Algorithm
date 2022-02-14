package SWEA.Week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 0;
        while (tc < 10) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            ArrayList<Character> list = new ArrayList<>();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);

                if (ch - '0' >= 0) {
                    list.add(ch);
                } else { // 숫자아닐때
                    if (stack.isEmpty()) {
                        stack.push(ch);
                    } else if (ch == ')') {
                        while (true) {
                            if (stack.peek() == '(') {
                                stack.pop();
                                break;
                            }
                            list.add(stack.pop());
                        }
                    } else { // 왼쪽괄호 or 연산자
                        if (ch == '(') {
                            stack.push(ch);
                        } else if (ch == '+') {
                            while (stack.peek() != '(') {
                                list.add(stack.pop());
                            }
                            stack.push(ch);
                        } else {
                            stack.push(ch);
                        }
                    }
                }
            }

            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }

            String change = "";
            for (int i = 0; i < list.size(); i++) {
                change = change + list.get(i);
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
            sb.append("#").append(tc).append(" ").append(sum).append('\n');
        }

        System.out.println(sb);
    }
}
