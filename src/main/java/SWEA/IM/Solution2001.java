package SWEA.IM;

import java.io.*;
import java.util.StringTokenizer;

public class Solution2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i = 0; i < N-M+1 ;i++) {
                for(int j = 0; j < N-M+1; j++) {

                    int sum = 0;
                    for(int k = i; k < i+M; k++) {
                        for(int l = j; l < j+M; l++) {
                            sum += arr[k][l];
                        }
                    }
                    max = Math.max(max,sum);
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.println(sb);
    }
}

