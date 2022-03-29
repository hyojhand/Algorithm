package Study.Week7;

import java.io.*;
import java.util.*;

public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            LinkedList<int[]> que = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                que.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!que.isEmpty()) {
                int[] num = que.poll();
                boolean flag = false;

                for (int i = 0; i < que.size(); i++) {
                    if (num[1] < que.get(i)[1]) {

                        que.offer(num);
                        for (int j = 0; j < i; j++) {
                            int[] temp = que.poll();
                            que.offer(temp);
                        }

                        flag = true;
                        break;
                    }
                }

                if (flag) continue;

                count++;
                if (num[0] == M) break;
            }
            sb.append(count).append('\n');

            T--;
        }

        System.out.println(sb);
    }
}
