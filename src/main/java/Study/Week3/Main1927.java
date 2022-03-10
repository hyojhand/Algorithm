package Study.Week3;

import java.io.*;
import java.util.PriorityQueue;

public class Main1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.size() == 0) {
                    sb.append(0).append('\n');
                }
                else {
                    sb.append(queue.poll()).append('\n');
                }
            }
            else {
                queue.add(num);
            }
        }

        System.out.println(sb);

    }
}
