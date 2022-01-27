package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        for(int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            switch (func) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.peek());
                        stack.pop();
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.peek());
                    }
                    break;
            }

        }


    }
}
