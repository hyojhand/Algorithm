package Study.Week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        sb.append("<");
        int count = 0;
        int num;
        while (!que.isEmpty()) {
            count++;
            num = que.poll();
            if (count % K == 0) {
                if (que.size() != 0) {
                    sb.append(num).append(", ");
                } else {
                    sb.append(num);
                }
            } else {
                que.offer(num);
            }
        }

        sb.append(">");
        System.out.println(sb);

    }
}
