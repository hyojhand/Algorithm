package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {
    static Integer[][] memo = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        while (T > 0) {
            int N = Integer.parseInt(br.readLine());

            fibo(N);
            sb.append(memo[N][0]).append(" ").append(memo[N][1]).append('\n');

            T--;
        }

        System.out.println(sb);

    }

    public static Integer[] fibo(int x) {
        if (memo[x][0] == null || memo[x][1] == null) {
            memo[x][0] = fibo(x - 1)[0] + fibo(x - 2)[0];
            memo[x][1] = fibo(x - 1)[1] + fibo(x - 2)[1];
        }

        return memo[x];
    }

}
