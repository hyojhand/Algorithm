package Study.Week0;

import java.io.*;
import java.util.Stack;

public class Main17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack stack = new Stack();

        boolean tagOpen = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                tagOpen = true;

                while(!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }

                System.out.print(str.charAt(i));
            }
            else if(str.charAt(i) == '>') {
                tagOpen = false;
                System.out.print(str.charAt(i));
            }
            else if(tagOpen) {
                System.out.print(str.charAt(i));
            }
            else {
                if(str.charAt(i) == ' ') {
                    while(!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(" ");
                }
                else {
                    stack.push(str.charAt(i));
                }
            }

        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
