package Programmers.Kakao.Kakao2021;

import java.util.*;

// 2021 카카오 채용연계형 인턴십 - 거리두기 확인하기
// 각 행마다 대기실 정보를 통해 대기실 별로 배열을 만들며 탐색한다. 이때 각 대기실의 응시자는 큐에 담아놓는다.
// 응시자를 확인하며 한명이라도 근접해있다면 0을 반환한다.
// 근접여부 확인을 위해 각 응시자 주변으로 bfs를 2번 실행해 맨해튼 거리 2 이내의 응시자를 찾는다.
// 응시자가 발견되면 바로 return 해준다.
class DistanceCheck {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 행별로 각 대기실 탐색
        for (int i = 0; i < places.length; i++) {

            // 대기실 배열
            Character[][] arr = new Character[places.length][places[i].length];
            // 응시자를 넣을 큐
            Queue<Point> que = new LinkedList<>();

            // 대기실 배열 만들기
            for (int j = 0; j < places[i].length; j++) {

                for (int k = 0; k < places[i][j].length(); k++) {
                    arr[j][k] = places[i][j].charAt(k);

                    // 응시자(P)라면 큐에 담기
                    if (arr[j][k] == 'P') {
                        que.offer(new Point(j, k));
                    }
                }
            }

            // 결과
            answer[i] = getResult(arr, que);
        }

        return answer;
    }

    private int getResult(Character[][] arr, Queue<Point> que) {

        // 응시자를 확인하면서 하나라도 근접해있다면 0 반환
        while (!que.isEmpty()) {
            Point player = que.poll();

            if (isClose(player, arr)) {
                return 0;
            }
        }

        return 1;
    }

    private boolean isClose(Point player, Character[][] arr) {
        // bfs 탐색
        Queue<Point> que = new LinkedList<>();
        que.offer(player);
        // 방문여부 체크
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[player.x][player.y] = true;

        // 맨헤튼 거리 2 이내를 탐색을 위해 bfs 2번 실행
        int distance = 0;
        while (!que.isEmpty()) {
            if (distance == 2) {
                break;
            }

            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point p = que.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx < arr.length && ny < arr[0].length
                            && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
                        // 응시자가 있다면 return
                        if (arr[nx][ny] == 'P') {
                            return true;
                        }

                        if (arr[nx][ny] == 'O') {
                            visited[nx][ny] = true;
                            que.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            distance++;
        }

        return false;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
