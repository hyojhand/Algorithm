package Study.Week13;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 중앙값 구하기
public class Main2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()); ;
            for(int i = 0; i < M; i++) {
                if(i%10==0 && i/10>0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());

                if(pq.size() == 0) {
                    pq.offer(num);
                }
                else {
                    if(pq.peek() < num) pq2.offer(num);
                    else pq.offer(num);
                }

                if(pq.size() == pq2.size()+2) {
                    int temp = pq.poll();
                    pq2.offer(temp);
                } else if(pq2.size() == pq.size()+2) {
                    int temp = pq2.poll();
                    pq.offer(temp);
                }

                if(i%2 ==0) {
                    cnt++;
                    if(pq.size() >= pq2.size()) sb.append(pq.peek()).append(" ");
                    else sb.append(pq2.peek()).append(" ");
                    if(cnt%10==0) sb.append('\n');
                }

            }
            result.append(cnt).append('\n');
            result.append(sb).append('\n');
        }

        System.out.println(result);
    }
}
