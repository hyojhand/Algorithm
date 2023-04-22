package Baekjoon.FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;

// G4 저울
// 단방향으로 연결된 경로를 boolean 배열로 true 설정
// 플로이드 워셜로 중간 경로를 포함해서 경로가 있다면 true 설정 변경
// 자신을 제외하고 양방향을 확인했을 때 연결된 경로가 없을 때 카운트
public class Main10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = true;
        }

        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                // 자기자신 제외
                if (i == j) {
                    continue;
                }

                // 연결된 경로가 없을 때 카운트
                if (!arr[i][j] && !arr[j][i]) {
                    count++;
                }
            }

            answer.append(count).append('\n');
        }

        System.out.println(answer);
    }
}

