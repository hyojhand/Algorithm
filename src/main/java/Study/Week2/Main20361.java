package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main20361 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cup = new int[N + 1];
        cup[X] = 1;
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == X) {
                cup[a] = 0;
                cup[b] = 1;
                X = b;
            } else if (b == X) {
                cup[a] = 1;
                cup[b] = 0;
                X = a;
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (cup[i] == 1) {
                result = i;
                break;
            }
        }

        System.out.print(result);

    }
}
