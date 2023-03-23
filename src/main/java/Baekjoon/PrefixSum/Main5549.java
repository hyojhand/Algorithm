package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

// G5 행성 탐사
// 3차원 배열을 만들어 각 위치에서 3곳의 정보를 누적 합한다.
// 누적합 계산으로 좌표를 빼서 원하는 영역의 개수를 구한다.
public class Main5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        int[][][] planet = new int[N + 1][M + 1][3];
        for (int i = 1; i <= N; i++) {
            String value = br.readLine();
            for (int j = 1; j <= M; j++) {
                char area = value.charAt(j - 1);

                if (area == 'J') {
                    planet[i][j][0] = 1;
                } else if (area == 'O') {
                    planet[i][j][1] = 1;
                } else {
                    planet[i][j][2] = 1;
                }
            }
        }

        // 행 데이터 누적 합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 3; k++) {
                    planet[i][j][k] += planet[i - 1][j][k];
                }
            }
        }

        // 열 데이터 누적 합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 0; k < 3; k++) {
                    planet[i][j][k] += planet[i][j - 1][k];
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            // 누적합 계산 - (nx,ny) - (x-1, ny) - (nx,y-1) + (x-1,y-1)
            for (int k = 0; k < 3; k++) {
                int answer = planet[nx][ny][k] - planet[x - 1][ny][k] - planet[nx][y - 1][k]
                        + planet[x - 1][y - 1][k];
                result.append(answer).append(" ");
            }
            result.append('\n');
        }
        System.out.println(result);
    }
}

