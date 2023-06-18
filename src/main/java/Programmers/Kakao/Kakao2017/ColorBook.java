package Programmers.Kakao.Kakao2017;

import java.util.*;

// 2017 카카오코드 예선 - 카카오프렌즈 컬러링북
// BFS 탐색 문제
class ColorBook {
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(int m, int n, int[][] picture) {
        // 방문여부 확인 배열
        visited = new boolean[m][n];

        // 영역 개수, 최대 영역 개수
        int areaCount = 0;
        int maxAreaCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않고, 색칠하지 않은 0이 아니라면 탐색
                if (!visited[i][j] && picture[i][j] != 0) {
                    // 방문처리
                    visited[i][j] = true;
                    // 영역의 개수 bfs 탐색
                    int count = getAreaCount(i, j, picture, m, n);
                    // 영역 최대 개수 갱신
                    maxAreaCount = Math.max(maxAreaCount, count);
                    // 영역 개수 + 1
                    areaCount++;
                }

            }
        }

        return new int[]{areaCount, maxAreaCount};
    }

    private int getAreaCount(int x, int y, int[][] picture, int m, int n) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        // 영역 색깔
        int color = picture[x][y];
        // 영역 개수
        int count = 1;
        while (!que.isEmpty()) {

            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                // 범위내의 방문하지 않고, 색이 같다면 탐색
                if (nx >= 0 && ny >= 0 && nx < m && ny < n
                        && !visited[nx][ny] && picture[nx][ny] == color) {
                    visited[nx][ny] = true;
                    count++;
                    que.offer(new Point(nx, ny));
                }
            }
        }

        return count;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}