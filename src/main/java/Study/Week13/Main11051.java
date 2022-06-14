package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;

// 이항계수2
public class Main11051 {
    static int[] memo;
    static int p = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new int[N+1];
        memo[0] = 1;
        memo[1] = 1;

        int a = fac(N);
        int temp = fac(K)*fac(N-K)%p;
        int b =pow(p-2, temp);

        System.out.println(a * b %p);
    }
    public static int fac(int n) {
        if(memo[n] == 0) {
            return memo[n] = (n * fac(n-1))%p;
        }

        return memo[n];
    }

    public static int pow(int n, int num) {
        if(n == 1) return num % p;

        int res = pow(n/2,num);

        if(n%2 == 0) return res*res%p;
        else return (res*res%p)*num%p;
    }
}
