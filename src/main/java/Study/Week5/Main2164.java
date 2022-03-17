package Study.Week5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }
        if(N == 1) {
            System.out.println(1);
        } else {
            while(true) {
                que.poll();
                if(que.size() == 1) break;
                int num = que.poll();
                que.offer(num);
            }

            System.out.println(que.poll());
        }

    }
}
