package SWEA.Week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CipherGenerate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int tcase = Integer.parseInt(st.nextToken());

            Queue<Integer> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isZero = false;
            while (true) {
                for (int i = 1; i < 6; i++) {
                    int num = que.poll() - i;
                    if (num <= 0) {
                        isZero = true;
                        num = 0;
                        que.offer(num);
                        break;
                    }
                    que.offer(num);
                }
                if (isZero) break;
            }

            sb.append("#").append(tcase).append(" ");

            for (int i = 0; i < 8; i++) {
                sb.append(que.poll()).append(" ");
            }
            sb.append('\n');

            if(tcase == 10) {
                break;
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
