package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] card1 = new String[N / 2 + 1];
            String[] card2 = new String[N / 2];

            int idx1 = 0;
            int idx2 = 0;
            for (int i = 0; i < N; i++) {
                if (N % 2 != 0 && i == N / 2) {
                    card1[idx1] = st.nextToken();
                    continue;
                }

                if (i < N / 2) {
                    card1[idx1] = st.nextToken();
                    idx1++;
                } else if (i >= N / 2) {
                    card2[idx2] = st.nextToken();
                    idx2++;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ");

            idx1 = 0;
            idx2 = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    sb.append(card1[idx1]).append(" ");
                    idx1++;
                } else {
                    sb.append(card2[idx2]).append(" ");
                    idx2++;
                }
            }


            sb.append('\n');
        }

        System.out.println(sb);
    }
}
