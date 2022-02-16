package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[0] < arr[i]) {
                    stack.pop();
                }
                else {
                    result[i] = stack.peek()[1];
                    stack.push(new int[] {arr[i],i+1});
                    break;
                }
            }

            if(stack.isEmpty()) {
                stack.push(new int[] {arr[i],i+1});
                result[i] = 0;
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

    }
}


