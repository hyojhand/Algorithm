package Study.Week8;

import java.io.*;
import java.util.StringTokenizer;
// 평범한 배낭
public class Main12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] memo = new int[N+1][K+1];
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K;j ++) {
                if(W[i] > j) {
                    memo[i][j] = memo[i-1][j];
                } else {
                    memo[i][j] = Math.max(memo[i-1][j-W[i]] + V[i], memo[i-1][j]);
                }
            }
        }

        System.out.println(memo[N][K]);
    }

}
