package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class GateDoor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            int count = 0;
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 1) {
                    count = 0;
                } else {
                    count++;

                    if (count == D) {
                        result++;
                        count = 0;
                    }
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }
        System.out.println(sb);

    }
}
