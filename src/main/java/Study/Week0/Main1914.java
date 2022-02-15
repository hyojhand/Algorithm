package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1914 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bigint = new BigInteger("1");
        int N = Integer.parseInt(br.readLine());
        if (N <= 20) {
            count = (int) (Math.pow(2, N) - 1);
            sb.append(count).append('\n');
            hanoi(N, 1, 2, 3);
            System.out.println(sb);
        } else {
            for (int i = 0; i < N; i++) {
                bigint = bigint.multiply(new BigInteger("2"));
            }
            bigint = bigint.subtract(new BigInteger("1"));
            System.out.println(bigint);
        }

    }

    public static void hanoi(int n, int from, int temp, int to) {
        if (n == 0) return;

        hanoi(n - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append('\n');
        hanoi(n - 1, temp, from, to);
    }

}
