package Study.Week20_24;

import java.io.*;
import java.util.StringTokenizer;
// 행렬 제곱
public class Main10830 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(arr, B);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[][] pow(int[][] T, long dept) {

        if(dept == 1) {
            return T;
        }

        int[][] temp = pow(T, dept/2);

        temp = multi(temp,temp);

        if(dept % 2 == 1) {
            temp = multi(temp, arr);
        }
        return temp;
    }

    private static int[][] multi(int[][] a1, int[][] a2) {

        int[][] b = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    b[i][j] += a1[i][k] * a2[k][j];
                    b[i][j] %= 1000;
                }
            }
        }

        return b;
    }
}


