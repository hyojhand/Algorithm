package Study.Week6;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            que.offer(i);
        }

        int cnt = 0;
        while(!que.isEmpty()) {
            cnt++;
            int num = que.poll();

            if(que.isEmpty()) {
                sb.append(num).append(">");
                break;
            }

            if(cnt == K) {
                sb.append(num).append(", ");
                cnt = 0;
            } else {
                que.offer(num);
            }
        }

        System.out.println(sb);

    }
}
