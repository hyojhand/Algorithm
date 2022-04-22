package Study.Week10;

import java.io.*;
import java.util.StringTokenizer;

// 이항계수 3
public class Main11401 {
    static long p = 1000000007;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new long[N+1];
        memo[0] = 1;
        memo[1] = 1;

        long a = fact(N);
        long temp = fact(K)*fact(N-K)%p;
        long b = pow(p-2,temp);

        System.out.println((a * b) % p);
    }

    static long fact(int a) {
        if(a == 0) return memo[0];

        if(memo[a] == 0) {
            memo[a] = fact(a-1)*a % p;
        }
        return memo[a];
    }

    public static long pow(long n,long num) {
        if(n == 1) return num % p;

        long res = pow(n/2,num);

        if(n % 2 == 0) return res*res%p;
        else return (res*res %p)*num %p;
    }
}
