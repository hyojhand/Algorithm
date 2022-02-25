package Study.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            Integer[] A = new Integer[a];
            for (int j = 0; j < a; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A, Collections.reverseOrder());


            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());

            Integer[] B = new Integer[b];
            for (int j = 0; j < b; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B, Collections.reverseOrder());

            String winner = "";

            int min = Math.min(A.length, B.length);
            for (int k = 0; k < min; k++) {
                if (A[k] > B[k]) {
                    winner = "A";
                    break;
                } else if (A[k] < B[k]) {
                    winner = "B";
                    break;
                }
            }
            if (winner.equals("")) {
                if (A.length > B.length) winner = "A";
                else if (B.length > A.length) winner = "B";
                else winner = "D";
            }
            sb.append(winner).append('\n');
        }

        System.out.println(sb);

    }
}
