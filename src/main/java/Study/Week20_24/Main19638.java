package Study.Week20_24;

import java.io.*;
import java.util.*;
// 센티와 마법의 뿅망치
public class Main19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int t = 0;
        while(t < T) {
            if(pq.peek() < H) break;

            if(pq.peek() != 1) pq.offer(pq.poll()/2);
            t++;
        }

        StringBuilder sb = new StringBuilder();
        if(pq.peek() < H) sb.append("YES").append('\n').append(t);
        else sb.append("NO").append('\n').append(pq.peek());

        System.out.println(sb);
    }
}

