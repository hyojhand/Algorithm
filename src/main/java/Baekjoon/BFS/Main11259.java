package Baekjoon.BFS;

import java.io.*;
import java.util.*;

// G4 Puyo Puyo
// 1. BFS로 연쇄작용을 일으켜 터트린다. 이때 연쇄 가능한 갯수인지 확인하기 위해 리스트에 담아서 갯수를 비교해간다.
// 2. 재배치할때 열마다 큐에 담아서 아래부터 다시 채워준다.
public class Main11259 {

    private static final int ROW = 12;
    private static final int COL = 6;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            String input = br.readLine();
            for (int j = 0; j < COL; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        // 연쇄 횟수
        int answer = 0;

        // 연쇄작용이 일어나면 계속 반복
        while (bomb()) {
            // 중력에 의해 떨어지기
            rebase();

            // 연쇄 횟수 + 1
            answer++;
        }

        System.out.println(answer);
    }

    private static void rebase() {
        for (int i = 0; i < COL; i++) {

            // 빈공간이 아니면 재배치 큐에 넣고
            Queue<Character> rebaseQue = new LinkedList<>();
            for (int j = ROW - 1; j >= 0; j--) {
                if (board[j][i] != '.') {
                    rebaseQue.offer(board[j][i]);
                    board[j][i] = '.';
                }
            }


            int idx = ROW - 1;
            // 제일 아래 행부터 재배치 큐에 담긴 알파벳을 넣어준다
            while (!rebaseQue.isEmpty()) {
                board[idx][i] = rebaseQue.poll();
                idx--;
            }

        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;

    static boolean bomb() {

        // 방문여부 체크
        check = new boolean[ROW][COL];

        // 연쇄작용이 한번이라도 일어났는지 여부
        boolean isBomb = false;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                // 빈공간은 무시
                if (board[i][j] == '.') {
                    continue;
                }

                // 방문하지 않았다면, bfs로 연결된게 4개 이상인지 확인
                if (!check[i][j]) {
                    check[i][j] = true;

                    // 연쇄작용이 일어났으면
                    if (bfs(i, j)) {
                        isBomb = true;
                    }
                }

            }
        }

        return isBomb;
    }

    // 연쇄작용이 있으면 true 반환
    static boolean bfs(int x, int y) {
        // 연결된 요소 찾을 큐
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        List<Point> saveDestroys = new ArrayList<>();
        saveDestroys.add(new Point(x, y));

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (isSame(nx, ny, board[x][y]) && !check[nx][ny]) {
                    check[nx][ny] = true;
                    que.offer(new Point(nx, ny));
                    saveDestroys.add(new Point(nx, ny));
                }
            }
        }

        // 탐색이후 4개 이상 상하좌우로 연결되어 있다면 터진다
        if (saveDestroys.size() >= 4) {
            for (Point point : saveDestroys) {
                board[point.x][point.y] = '.';
            }
            return true;
        }

        // 터진게 없다면 false 반환
        return false;
    }

    private static boolean isSame(int x, int y, char color) {
        if (x < 0 || y < 0 || x >= ROW || y >= COL) {
            return false;
        }

        return board[x][y] == color;
    }


    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

