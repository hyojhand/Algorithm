package Study.Week7;

import java.io.*;
import java.util.*;

public class Main14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] memo = new int[N+1];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i = N-1; i >= 0; i--) {
            if(i + T[i] > N) memo[i] = memo[i+1];
            else {
                memo[i] = Math.max(memo[i+1],memo[i+T[i]] + P[i]);
            }
            max = Math.max(max, memo[i]);
        }

        System.out.println(max);

    }
}
