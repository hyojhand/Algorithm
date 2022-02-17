package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        sb.append(gcd(A, B)).append('\n');
        sb.append(lcm(A, B)).append('\n');

        System.out.println(sb);

    }

    public static int gcd(int a, int b) {
        int tmp;
        if (b > a) {
            tmp = a;
            a = b;
            b = tmp;
        }

        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }

    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
