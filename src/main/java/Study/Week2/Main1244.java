package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] button = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            button[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        int[][] change = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            change[i][0] = Integer.parseInt(st.nextToken());
            change[i][1] = Integer.parseInt(st.nextToken());

            if (change[i][0] == 1) {
                for (int j = 0; j < N; j++) {
                    if ((j + 1) % change[i][1] == 0) {
                        if (button[j] == 1) button[j] = 0;
                        else button[j] = 1;
                    }
                }
            } else {
                if (button[change[i][1] - 1] == 1) button[change[i][1] - 1] = 0;
                else button[change[i][1] - 1] = 1;

                int idx = 1;
                while (true) {
                    if (change[i][1] - 1 - idx < 0 || change[i][1] - 1 + idx >= N) break;

                    if (button[change[i][1] - 1 - idx] != button[change[i][1] - 1 + idx]) {
                        break;
                    } else {
                        if (button[change[i][1] - 1 - idx] == 1) {
                            button[change[i][1] - 1 - idx] = 0;
                            button[change[i][1] - 1 + idx] = 0;
                        } else {
                            button[change[i][1] - 1 - idx] = 1;
                            button[change[i][1] - 1 + idx] = 1;
                        }
                    }

                    idx++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (i % 20 == 0 && i != 0) {
                sb.append('\n');
            }
            sb.append(button[i]).append(" ");
        }
        System.out.println(sb);

    }
}
