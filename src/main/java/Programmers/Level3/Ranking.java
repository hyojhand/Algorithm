package Programmers.Level3;

import java.util.*;

// Level3 - 순위
// wins[a][b] 배열은 a가 b를 이겼을 때 1로, 질땐느 0으로 설정한다.
// 플로이드 워셜 알고리즘으로 k를 통해 승부를 정할 수 있다면 [a][b]는 1로, [b][a]는 0으로 설정한다.
// 모든 결과를 확인하며 결과를 알 수 있는 (1 or 0) 개수가 자신을 제외한 모든 개수라면 결과를 알 수 있으므로 값을 갱신한다.
class Ranking {
    private final int INF = 9999999;

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] wins = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(wins[i], INF);
        }

        for (int[] result : results) {
            int from = result[0];
            int to = result[1];
            wins[from][to] = 1;
            wins[to][from] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (wins[i][k] == 1 && wins[k][j] == 1) {
                        wins[i][j] = 1;
                        wins[j][i] = 0;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (wins[i][j] != INF) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
