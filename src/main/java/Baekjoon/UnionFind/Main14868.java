package Baekjoon.UnionFind;

import java.io.*;
import java.util.*;

// P4 문명
// 먼저, 현재 큐에 문명의 위치를 넣어주고, 인접한 위치에 다른 문명이 있는지 확인한다.
// 따른 문명이 있다면, 해당 문명과 Union 해주고 전체 문명개수를 하나 줄인다. 이를 확인하면서 BFS할 큐에 해당 위치를 넣어주어야 한다.
// BFS하여 문명이 전파되기 전에, 총 문명 개수가 1개라면 반복문을 break 해준다.
// BFS 탐색하여 문명을 한칸씩 전파하며, 시간을 늘려주어 반복한다.
public class Main14868 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int totalCount = 0; // 총 문명 개수
    private static DisjointSet disjointSet;
    private static Queue<Point> que; // 인접한 문명을 확인할 큐
    private static Queue<Point> findQue; // BFS하여 문명이 퍼질 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][N + 1];

        que = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = i + 1; // i + 1번 문명의 시작점
            que.offer(new Point(a, b));
            totalCount++;
        }

        disjointSet = new DisjointSet(K);
        findQue = new LinkedList<>();

        int time = 0;
        while (true) {
            findUnion(board, N); // 인접한 문명 확인

            if (totalCount == 1) break;

            bfs(board, N); // 문명 전파(상하좌우)

            time++;
        }

        System.out.println(time);
    }

    // 인접한 문명을 union
    private static void findUnion(int[][] board, int N) {
        while (!que.isEmpty()) {
            Point point = que.poll();
            findQue.offer(point);

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N || board[nx][ny] == 0) continue;

                // 둘이 다른 문명인데 옆에 있다면 union 하면서 총 문명 개수 줄이기
                if (disjointSet.unionSet(board[point.x][point.y], board[nx][ny])) {
                    totalCount--;
                }
            }
        }
    }

    // BFS하여 문명 전파
    private static void bfs(int[][] board, int N) {
        boolean[][] visisted = new boolean[N + 1][N + 1];
        while (!findQue.isEmpty()) {
            Point point = findQue.poll();
            visisted[point.x][point.y] = true;

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N || visisted[nx][ny]) continue;
                visisted[nx][ny] = true;

                // 비어있다면
                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[point.x][point.y];
                    que.offer(new Point(nx, ny));
                }
            }
        }
    }


    static class DisjointSet {
        int[] parents;

        public DisjointSet(int N) {
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }
        }

        public int findSet(int a) {
            if (parents[a] == a) return a;
            return parents[a] = findSet(parents[a]);
        }

        public boolean unionSet(int a, int b) {
            int aRoot = findSet(a);
            int bRoot = findSet(b);

            if (aRoot == bRoot) return false;

            parents[bRoot] = aRoot;
            return true;
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
