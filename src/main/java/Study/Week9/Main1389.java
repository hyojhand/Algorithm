package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 케빈 베이컨의 6단계 법칙
public class Main1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 9999999;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j && arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i != j) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                    }
                }
            }
        }

        int[] member = new int[N+1];
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }
            member[i] = sum;
            if(min > sum) {
                min = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}

