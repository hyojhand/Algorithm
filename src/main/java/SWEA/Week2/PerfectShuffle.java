package SWEA.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class PerfectShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] arr1 = new String[N / 2 + 1];
            int index1 = 0;
            String[] arr2 = new String[N / 2];
            int index2 = 0;
            for (int i = 0; i < N; i++) {
                if (N % 2 != 0) {
                    if (i <= N / 2) {
                        arr1[index1] = st.nextToken();
                        index1++;
                    } else {
                        arr2[index2] = st.nextToken();
                        index2++;
                    }
                } else {
                    if (i < N / 2) {
                        arr1[index1] = st.nextToken();
                        index1++;
                    } else {
                        arr2[index2] = st.nextToken();
                        index2++;
                    }
                }
            }

            String[] shuffle = new String[N];
            index1 = 0;
            index2 = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    shuffle[i] = arr1[index1];
                    index1++;
                } else {
                    shuffle[i] = arr2[index2];
                    index2++;
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                sb.append(shuffle[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
