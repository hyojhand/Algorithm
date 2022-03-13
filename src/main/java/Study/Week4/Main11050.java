package Study.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main11050 {
    static Integer[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new Integer[N+1];
        memo[0] = 1;
        memo[1] = 1;

        int result = fac(N)/(fac(K)*fac(N-K));
        System.out.println(result);
    }
    public static int fac(int n) {

        if(memo[n] == null) {
            return memo[n] = n * fac(n-1);
        }
        else return memo[n];
    }
}
