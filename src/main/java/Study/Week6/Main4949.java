package Study.Week6;

import java.io.*;
import java.util.Stack;

public class Main4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.length() == 1) break;
            Stack<Character> stack = new Stack<>();
            boolean isOk = true;

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(ch == '(') {
                    stack.push(ch);
                } else if(ch == '[') {
                    stack.push(ch);
                } else if(ch == ')') {
                    if(stack.isEmpty()) {
                        isOk = false;
                        break;
                    } else {
                        char temp = stack.pop();
                        if(temp != '(') {
                            isOk = false;
                            break;
                        }
                    }
                } else if(ch == ']') {
                    if(stack.isEmpty()) {
                        isOk = false;
                        break;
                    } else {
                        char temp = stack.pop();
                        if(temp != '[') {
                            isOk = false;
                            break;
                        }
                    }
                }

            }

            if(!stack.isEmpty()) isOk = false;

            if(isOk) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }

        System.out.println(sb);

    }
}

