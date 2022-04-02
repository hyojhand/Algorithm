package Study.Week7;

import java.io.*;
import java.util.*;

public class Main1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        while(N > 0) {
            int num = Integer.parseInt(br.readLine());
            if(pq.size() == 0) {
                pq.offer(num);
            } else {
                if(pq.peek() < num) pq2.offer(num);
                else pq.offer(num);
            }

            if(pq.size() == pq2.size()+2) {
                int temp = pq.poll();
                pq2.offer(temp);
            } else if (pq2.size() == pq.size()+2) {
                int temp = pq2.poll();
                pq.offer(temp);
            }

            int result;
            if(pq.size() >= pq2.size()) {
                result = pq.peek();
            } else {
                result = pq2.peek();
            }

            sb.append(result).append('\n');

            N--;
        }
        System.out.println(sb);

    }
}

