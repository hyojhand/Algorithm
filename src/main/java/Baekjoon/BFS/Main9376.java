package Baekjoon.BFS;

import java.io.*;
import java.util.*;

// P4 탈옥
// 죄수1, 죄수2, 외부자가 각 위치에서 맵을 이동하는데 열게 된 문의 횟수를 구한다.
// 외부자는 자유로운 이동이 가능하므로 전체 배열의 크기를 1씩 늘린 상태로 구현한다.
// 문을 연 개수를 가지는 행렬의 방문 처리를 위해 최초 -1로 초기화하고, 각 시작 위치에서 0으로 BFS 탐색을 시작한다.
// 한번도 방문하지 않았거나, 문을 연 횟수가 최소값이라면 해당 경로로 갱신하기 위해 큐에 넣고, 문을 만나면 + 1을 해주며 BFS 탐색한다.
// 최종적으로 세 곳의 방문 횟수 배열의 값을 더하고 최소값을 구해 갱신한다.
// 이때, 세곳에서 한번이라도 방문하지 않은 곳은 제외하고, 해당 위치가 문이라면 나머지 2명이 중복된 문의 개수 카운트를 줄이기 위해 -2를 처리해준다.
public class Main9376 {

    private static final char WALL = '*';
    private static final char DOOR = '#';
    private static final char PRISONER = '$';
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static int h, w;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            Point[] prisoners = new Point[2];
            int prisonerIndex = 0;

            board = new char[h + 2][w + 2]; // 맵의 주변을 1행열씩 늘려준다 (밖에서 상근이의 자유로운 이동을 위해)

            for (int i = 1; i <= h; i++) {
                String input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    board[i][j] = input.charAt(j - 1);

                    if (board[i][j] == PRISONER) {
                        prisoners[prisonerIndex] = new Point(i, j);
                        prisonerIndex++;
                    }
                }
            }

            int[][] prisonerDoor = openDoor(prisoners[0]);
            int[][] prisonerDoor2 = openDoor(prisoners[1]);
            int[][] ownerDoor = openDoor(new Point(0, 0));

            int answer = Integer.MAX_VALUE;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (board[i][j] == WALL) {
                        continue;
                    }

                    // 한번도 방문하지 않은 곳이면 continue
                    if (prisonerDoor[i][j] == -1 || prisonerDoor2[i][j] == -1 || ownerDoor[i][j] == -1) {
                        continue;
                    }

                    int sum = prisonerDoor[i][j] + prisonerDoor2[i][j] + ownerDoor[i][j];
                    // 문을 만나면 중복된 횟수 2번 제외
                    if (board[i][j] == DOOR) {
                        sum -= 2;
                    }

                    answer = Math.min(answer, sum);
                }
            }

            result.append(answer).append('\n');
            T--;
        }

        System.out.println(result);
    }

    private static int[][] openDoor(Point start) {
        Queue<Point> que = new LinkedList<>();
        que.offer(start);

        int[][] count = new int[h + 2][w + 2];
        // -1로 방문처리
        for (int i = 0; i < h + 2; i++) {
            Arrays.fill(count[i], -1);
        }

        count[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Point point = que.poll();
            int x = point.x;
            int y = point.y;
            int doorCount = count[point.x][point.y];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위 밖이거나 벽을 만나면 continue
                if (isOutOfBound(nx, ny) || board[nx][ny] == WALL) continue;

                // 지금까지 문을 연 횟수
                int cnt = doorCount;
                if (board[nx][ny] == DOOR) {
                    // 문을 만나면 ++
                    cnt++;
                }

                // 한번도 방문하지 않았거나 최소 경로라면 큐에 넣기
                if (count[nx][ny] == -1 || cnt < count[nx][ny]) {
                    que.offer(new Point(nx, ny));
                    count[nx][ny] = cnt;
                }
            }
        }

        return count;
    }

    private static boolean isOutOfBound(int x, int y) {
        return x < 0 || y < 0 || x >= h + 2 || y >= w + 2;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


