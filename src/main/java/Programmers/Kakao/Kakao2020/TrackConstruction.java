package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 카카오 인턴십 - 경주로 건설
// BFS 탐색으로 최종 위치까지 도달하는데 드는 최소 비용을 계산한다.
// 이때, 해당 위치의 비용을 DP로 저장하며 더 최소의 비용일 때만 큐에 추가하며 BFS 탐색한다.
// 하지만, 마지막 테스트 케이스에서 에러가 발생했다.
// 지나온 경로를 고려했을 때, 어떤 위치에서는 최소가 아니라도 그 이후부터는 최소의 선택이 가능한 경우가 있을 수 있다.
// 따라서, 이전에 지나온 방향을 고려한 3차원 DP 배열로 최소비용을 갱신해준다.
// Road 객체는 위치, 현재 비용, 진행하는 방향을 가지는 객체로 진행하는 방향과 같을 경우 직선으로 계산하여 직선 비용을 더해주고,
// 다른 방향일 경우 코너로 계산해서 코너 비용(500)을 더하고 방향을 갱신해준다.
// 방향은 시계방향인 상우하좌 순으로 계산해, 시계방향으로 180도 회전한 (+2) 방향이 다음 방향과 같다면 역주행이므로 제외시켜준다.
public class TrackConstruction {
    private final int STRAIGHT_COST = 100;
    private final int CORNER_COST = 500;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][][] costs;
    int N;

    public int solution(int[][] board) {
        N = board.length;
        costs = new int[N][N][4]; // 지나온 방향 고려, 상하좌우(0,2,3,1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(board);

        int answer = Integer.MAX_VALUE;
        // (N-1,N-1) 위치의 4방향 비용 최소값 계산
        for (int k = 0; k < 4; k++) {
            answer = Math.min(answer, costs[N - 1][N - 1][k]);
        }
        return answer;
    }

    private void bfs(int[][] board) {
        Queue<Road> roads = new LinkedList<>();
        roads.offer(new Road(new Point(0, 0), 0, 1)); // 오른쪽으로 출발
        roads.offer(new Road(new Point(0, 0), 0, 2)); // 아래쪽으로 출발

        while (!roads.isEmpty()) {
            Road r = roads.poll();
            Point p = r.point;

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                // 범위를 벗어나거나 벽을 만나면 continue
                if (isOutOfRange(nx, ny) || board[nx][ny] == 1) {
                    continue;
                }

                // 진행방향의 반대 방향(역주행)이라면 continue
                if (k == (r.dir + 2) % 4) {
                    continue;
                }

                Point nextPoint = new Point(nx, ny);
                int nextCost = r.cost + STRAIGHT_COST;
                int nextDir = r.dir;

                // 진행해온 방향과 같은 방향이 아니라면 코너 비용 추가 및 방향 전환
                if (k != r.dir) {
                    nextDir = k;
                    nextCost += CORNER_COST;
                }

                // 다음 비용이 최소라면 비용 갱신 및 큐에 추가
                if (nextCost <= costs[nx][ny][nextDir]) {
                    costs[nx][ny][nextDir] = nextCost;
                    roads.offer(new Road(nextPoint, nextCost, nextDir));
                }
            }
        }
    }

    private boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    class Road {
        Point point;
        int cost, dir;

        public Road(Point point, int cost, int dir) {
            this.point = point;
            this.cost = cost;
            this.dir = dir;
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
