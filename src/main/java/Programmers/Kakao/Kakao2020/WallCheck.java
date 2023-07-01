package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 KAKAO BLIND RECRUITMENT - 외벽 점검
// dist의 거리가 가장 긴 순서대로 정렬하면 효율이 가장 좋다.
// dist의 최대가 8개이므로 DFS로 탐색해서 최소 개수를 구해준다.
// 각 지점에서 시작하여 dist 거리만큼 탐색했을 때 몇 개의 지점을 커버할 수 있는지 확인해준다.
// 이때, weak는 오름차순으로 주어져 현재 지점 이전의 거리는 무조건 작으므로,
// 원형을 직선으로 생각하기 위해 현재 지점 이전의 거리는 총 둘레 거리를 더한 값이 (현재 지점 + 커버가능 거리) 보다 작은 개수를 카운트 및 방문처리하고
// 현재 지점 이후의 거리에서 (현재 지점 + 커버가능 거리) 보다 작은 개수를 카운트 및 방문처리한다.
public class WallCheck {
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        // 거리가 긴 순서대로 내림차순 정렬
        Arrays.sort(dist);
        int[] distSort = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            distSort[i] = dist[dist.length - i - 1];
        }

        dfs(0, 0, new boolean[weak.length], distSort, weak, n);
        // 초기값과 같다면 -1로 반환
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        return answer;
    }

    private void dfs(int index, int visitCount, boolean[] visited, int[] dist, int[] weak, int n) {
        // 모든 곳을 확인했다면 최소 개수 갱신
        if (visitCount == weak.length) {
            answer = Math.min(answer, index);
            return;
        }

        // 점검할 수 있는 곳을 모두 점검하여 index가 크다면 return
        if (dist.length <= index) {
            return;
        }

        // 각 지점을 시작지점으로 탐색한다
        for (int i = 0; i < weak.length; i++) {
            // 만약 아직 탐색하지 않았다면
            if (!visited[i]) {
                // 복사해서 만든 boolean 배열 사용
                boolean[] copyVisited = visited.clone();
                copyVisited[i] = true;
                // 시작 지점의 거리
                int start = weak[i];
                // index번째의 탐색하는 길이
                int distance = dist[index];

                // 현재 지점을 시작으로 탐색하는 총 개수
                int count = 1;
                // 현재 지점보다 이전의 거리는 둘레 길이를 더해서 계산한다
                for (int k = 0; k < i; k++) {
                    // 직선으로 생각했을 때, 현재 지점 + 커버할 수 있는 거리보다 커지면 break
                    if (weak[k] + n > start + distance) {
                        break;
                    }

                    // 아직 탐색하지 않은 곳을 탐색한다면 true 처리, 카운트 갱신
                    if (!copyVisited[k]) {
                        copyVisited[k] = true;
                        count++;
                    }
                }

                // 현재 지점의 다음 지점부터 탐색
                for (int k = i + 1; k < weak.length; k++) {
                    // 해당 지점이 시작 지점에서 커버할 수 있는 거리보다 커지면 break
                    if (weak[k] > start + distance) {
                        break;
                    }

                    // 아직 탐색하지 않은 곳이면 true 처리, 카운트 갱신
                    if (!copyVisited[k]) {
                        copyVisited[k] = true;
                        count++;
                    }
                }

                // 다음 index의 커버가능 거리로 DFS 탐색
                dfs(index + 1, visitCount + count, copyVisited, dist, weak, n);
            }
        }

    }
}
