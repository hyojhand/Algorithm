package Programmers.Kakao.Kakao2023;
// 2023 KAKAO BLIND RECRUITMENT - 미로 탈출 명령어
// 오름차순으로 dfs하면서 처음 도착한 순서가 가장 첫번째 오름차순 명령어이다.
// 출발과 도착지점의 차이 % 2가 홀수이면 도착할 수 없다.
class MazeEscapeCommand {
    // d, l, r, u 순서로 움직인다.
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] record = {"d", "l", "r", "u"};
    String answer = "impossible";
    boolean stop = false;
    Point end;
    int n, m;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        end = new Point(r, c);
        this.n = n;
        this.m = m;

        boolean possible = isPossible(x, y, k);
        // 이동할 수 있다면 dfs로 탐색
        if (possible) {
            dfs(x, y, k, "");
        }

        return answer;
    }

    // x,y 에서 목표지점까지 k로 갈 수 있는지 확인
    private boolean isPossible(int x, int y, int k) {
        int diff = Math.abs(x - end.x) + Math.abs(y - end.y);
        return diff <= k && (k - diff) % 2 != 1;
    }

    private void dfs(int x, int y, int count, String moveRecord) {
        // 이미 답을 구했거나, 더이상 움직일 수 없으면 return
        if (stop || count < 0) {
            return;
        }
        // 좌표가 목표지점에 도달했다면, 최단거리 오름차순이므로 답을 바꾸고 stop상태로 return
        if (x == end.x && y == end.y && count == 0) {
            stop = true;
            answer = moveRecord;
            return;
        }

        for (int k = 0; k < 4; k++) {
            if (stop) {
                return;
            }

            int nx = x + dx[k];
            int ny = y + dy[k];

            // 다음 좌표가 범위안에 있고, 목표지점까지 count - 1만큼 이동할 수 있으면
            if (isInBound(nx, ny, n, m) && isPossible(nx, ny, count - 1)) {
                dfs(nx, ny, count - 1, moveRecord + record[k]);
            }
        }
    }

    private boolean isInBound(int x, int y, int n, int m) {
        return x > 0 && y > 0 && x <= n && y <= m;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
