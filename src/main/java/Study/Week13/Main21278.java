package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 호석이 두마리치킨?
public class Main21278 {
    static final int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int a = 1;
        int b = 1;
        for(int i = 1; i < N; i++) {
            for(int j = i+1; j <= N; j++) {
                int sum = 0;
                for(int k = 1; k <= N; k++) {
                    sum += Math.min(arr[i][k],arr[j][k]);
                }

                if(min > sum) {
                    min = sum;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(a +" "+ b +" "+ min*2);
    }
}

