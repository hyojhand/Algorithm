package SWEA.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Pari {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 테스트케이스만큼 반복
        int tc_count = 0;
        while (tc_count < tc) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 배열에 값 입력
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;

                    // M만큼의 배열을 돌면서 최대값계산
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += arr[k][l];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            tc_count++;
            sb.append("#").append(tc_count).append(" ");
            sb.append(max).append('\n');
        }

        System.out.println(sb);

    }
}
