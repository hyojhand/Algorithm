package SWEA.Week2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Cryptogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tcase = 0;
        while (tcase < 10) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.offer(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int mcount = 0;
            while (mcount < M) {
                if (st.nextToken().equals("I")) mcount++;
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int i = 0; i < y; i++) {
                    list.add(x, Integer.parseInt(st.nextToken()));
                    x++;
                }
            }

            tcase++;
            sb.append("#").append(tcase).append(" ");

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
}
