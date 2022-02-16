package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[1000001];
        check[1] = true;

        for (int i = 2; i < check.length; i++) {
            if (!check[i]) {
                for (int j = i + i; j < check.length; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!check[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);

    }
}
