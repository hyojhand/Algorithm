package Baekjoon.BFS;

import java.io.*;
import java.util.*;

// P5 백조의 호수
// 백조가 이동해서 탐색할 큐, 물이 얼음을 만나 녹일 큐 2개로 사용
// 백조가 이동하는 큐에서 얼음을 만나면, 다음 탐색할 큐에 담아준다.
// 물이 얼음을 만나면 해당 얼음을 물로 녹이고, 다음 얼음을 녹이기 위해 시작하도록 사용한다.
// 다른 백조를 만날 때 까지 반복하며 시간을 구한다.
public class Main3197 {

    private static final char WATER = '.';
    private static final char ICE = 'X';
    private static final char SWAN = 'L';
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static Point[] swan;

    private static Queue<Point> swanQue = new LinkedList<>(); // 백조가 탐색할 큐
    private static Queue<Point> waterQue = new LinkedList<>(); // 물 위치 큐

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        swan = new Point[2];
        int swanIndex = 0;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);

                if (board[i][j] == SWAN) {
                    swan[swanIndex] = new Point(i, j);
                    waterQue.offer(new Point(i, j)); // 백조의 위치도 물로 간주한다
                    swanIndex++;
                }

                if (board[i][j] == WATER) {
                    waterQue.offer(new Point(i, j));
                }
            }
        }

        swanQue.offer(swan[0]);
        visited = new boolean[R][C];
        visited[swan[0].x][swan[0].y] = true;

        int time = 0;
        while (true) {
            if (isSwanMeet(board, R, C)) break;

            meltIce(board, R, C);

            time++;
        }

        System.out.println(time);
    }

    private static boolean isSwanMeet(char[][] board, int R, int C) {
        Queue<Point> nextQue = new LinkedList<>();

        while (!swanQue.isEmpty()) {
            Point point = swanQue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                if (isOutOfBound(nx, ny, R, C) || visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == SWAN) {
                    return true;
                }

                visited[nx][ny] = true;

                if (board[nx][ny] == WATER) {
                    swanQue.offer(new Point(nx, ny));
                } else if (board[nx][ny] == ICE) {
                    nextQue.offer(new Point(nx, ny));
                }
            }
        }

        swanQue = nextQue;

        return false;
    }

    private static void meltIce(char[][] board, int R, int C) {
        int size = waterQue.size();
        for (int i = 0; i < size; i++) {
            Point water = waterQue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = water.x + dx[k];
                int ny = water.y + dy[k];

                if (isOutOfBound(nx, ny, R, C)) {
                    continue;
                }

                if (board[nx][ny] == ICE) {
                    waterQue.offer(new Point(nx, ny));
                    board[nx][ny] = WATER;
                }
            }
        }
    }


    private static boolean isOutOfBound(int x, int y, int R, int C) {
        return x < 0 || y < 0 || x >= R || y >= C;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}