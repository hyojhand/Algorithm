package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 KAKAO BLIND RECRUITMENT - 블록 이동하기
// 가로일때 좌측, 세로일때 위의 블록을 기준으로 구현한다.
// 시작점부터 BFS 탐색으로 4방향이동, 회전 가능 여부에 따라 회전을 하며 시간을 더해간다.
// 이때, 3차원 배열로 해당 지점에서 로봇이 가로, 세로인 경우의 방문 여부를 모두 탐색한다. (dir = 가로: 0, 세로 : 1)
// * 회전 가능여부 확인
// 현재 위치에서 회전할 수 있는 4가지 경우의 수에서, 체크해야하는 위치 cx,cy 배열, 회전했을 때 기준이 되는 위치로 변경값 rx,ry 배열로
// 각 위치로 회전해서 로봇이 이동할 수 있는지 확인해주면서 큐에 넣어준다.
// 가로, 세로 방향에 따라 최종 지점 이전에 도착했을 때의 시간의 최소값을 계산해준다.
public class BlockMove {
    int N;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] rx = {{0, -1, 0, -1}, {0, 0, 1, 1}};
    int[][] ry = {{1, 1, 0, 0}, {-1, 0, -1, 0}};
    int[][] cx = {{1, -1, 1, -1}, {1, 1, 0, 0}};
    int[][] cy = {{0, 0, 1, 1}, {-1, 1, -1, 1}};

    public int solution(int[][] board) {
        N = board.length;
        Machine start = new Machine(new Point(0, 0), 0, 0);
        return bfs(start, board);
    }

    private int bfs(Machine start, int[][] board) {
        Queue<Machine> que = new LinkedList<>();
        que.offer(start);

        boolean[][][] visited = new boolean[N][N][2];
        visited[0][0][0] = true;

        int answer = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Machine current = que.poll();
            Point currentPoint = current.point;

            // N에 도달하면 break
            if (isArriveFinal(current)) {
                answer = Math.min(answer, current.time);
                continue;
            }

            // 회전 가능하면 회전
            for (int k = 0; k < 4; k++) {
                int checkX = currentPoint.x + cx[current.dir][k];
                int checkY = currentPoint.y + cy[current.dir][k];
                if (canMove(checkX, checkY, board)) {

                    int nx = currentPoint.x + rx[current.dir][k];
                    int ny = currentPoint.y + ry[current.dir][k];
                    int ndir = (current.dir + 1) % 2;
                    // 방문가능 체크 & visited 체크
                    if (isMoveRange(nx, ny, ndir, board) && !visited[nx][ny][ndir]) {
                        visited[nx][ny][ndir] = true;
                        que.offer(new Machine(new Point(nx, ny), ndir, current.time + 1));
                    }
                }
            }

            // 범위 내라면, 4방향 이동
            for (int k = 0; k < 4; k++) {
                int nx = currentPoint.x + dx[k];
                int ny = currentPoint.y + dy[k];

                if (isMoveRange(nx, ny, current.dir, board) && !visited[nx][ny][current.dir]) {
                    que.offer(new Machine(new Point(nx, ny), current.dir, current.time + 1));
                    visited[nx][ny][current.dir] = true;
                }
            }
        }

        return answer;
    }

    private boolean isArriveFinal(Machine machine) {
        Point point = machine.point;
        // 방향에 따라, 로봇의 중심이 (N,N) 이전에 도착했을 때
        return (machine.dir == 0 && point.x == N - 1 && point.y == N - 2)
                || (machine.dir == 1 && point.x == N - 2 && point.y == N - 1);
    }

    private boolean isMoveRange(int nx, int ny, int dir, int[][] board) {
        return canMove(nx, ny, board) && ((dir == 0 && canMove(nx, ny + 1, board))
                || (dir == 1 && canMove(nx + 1, ny, board)));
    }

    private boolean canMove(int nx, int ny, int[][] board) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0;
    }

    static class Machine {
        Point point;
        int dir, time;

        public Machine(Point point, int dir, int time) {
            this.point = point;
            this.dir = dir;
            this.time = time;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
