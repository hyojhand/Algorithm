package Baekjoon.BFS;

import java.io.*;
import java.util.*;

// G4 소가 길을 건너간 이유 6
// 소의 위치를 저장하고, 각 좌표에서 연결된 길을 리스트로 저장한다.
// 이후, 2중 for문으로 전체 탐색하며 소의 위치에서 BFS 탐색을 실시한다.
// 자기 자신을 제외하고 bfs로 연결된 지점에서 길을 이동해야한다면 continue 해주어 길 없이 만날 수 있는 개수를 구한다.
// 이후, 전체에서 자신을 제외한 나머지 개수 중 길 없이 만날 수 있는 개수를 빼주면, 길을 지나야만 만날 수 있는 개수가 나온다.
// 몇 쌍인지 알아야 하므로, 전체 개수에서 2를 나눠주면 최종적으로 몇 쌍인지 구할 수 있다.
public class Main14466 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Point>[][] routes = new List[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                routes[i][j] = new ArrayList();
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());

            routes[fromX][fromY].add(new Point(toX, toY));
            routes[toX][toY].add(new Point(fromX, fromY));
        }

        boolean[][] isCow = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            isCow[x][y] = true;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isCow[i][j]) {
                    int count = bfs(isCow, routes, i, j, N, K);
                    answer += count;
                }
            }
        }

        System.out.println(answer / 2);
    }

    private static int bfs(boolean[][] isCow, List<Point>[][] routes, int x, int y, int N, int K) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[x][y] = true;

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        // 자기자신 제외
        int count = -1;
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (isCow[p.x][p.y]) {
                count++;
            }

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (isRoute(routes[p.x][p.y], nx, ny)) {
                    continue;
                }

                if (nx > 0 && ny > 0 && nx <= N && ny <= N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.offer(new Point(nx, ny));
                }
            }
        }

        // 자신을 뺀 나머지 소들 중에서 연결가능한 수를 제외하고, 길이 없으면 연결하지 못하는 쌍의 개수
        return (K - 1 - count);
    }

    // 길을 지나야 하면 true return
    private static boolean isRoute(List<Point> points, int nx, int ny) {
        for (Point point : points) {
            if (point.x == nx && point.y == ny) {
                return true;
            }
        }

        return false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

