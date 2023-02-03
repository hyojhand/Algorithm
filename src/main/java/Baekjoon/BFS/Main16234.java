package Baekjoon.BFS;

import java.io.*;
import java.util.*;
// G5 인구이동 - bfs 하여 연합이 가능한 연합들을 찾고 그 연합마다 인구를 배분해준다.
public class Main16234 {
    static int N, L, R;
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 도시 인구 배열
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 연합이 가능한 곳이 없다면 break
        while (getOpenCount() != 0) {
            answer++;
        }

        System.out.println(answer);
    }


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 연합 도시 탐색 및 인구배분
    static int bfs(int startX, int startY) {
        // 국경이 열리는 도시 리스트
        List<Point> openCities = new ArrayList<>();
        openCities.add(new Point(startX, startY));
        int sum = city[startX][startY];
        int count = 1;

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(startX, startY));

        // 연합이 가능한 도시는 리스트에 추가하고, sum과 count를 더해간다
        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (isOpen(p.x, p.y, nx, ny) && !visited[nx][ny]) {
                    que.offer(new Point(nx, ny));
                    openCities.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    sum += city[nx][ny];
                    count++;
                }
            }
        }

        // 연합이 없으면 본인 인구수 그대로, 연합이 생겼다면 평균 인구수 계산된다
        int avgPeople = sum / count;

        // 인구수 변경
        for (Point p : openCities) {
            city[p.x][p.y] = avgPeople;
        }

        // 본인을 제외하고 열린 갯수를 return (연합이 있다면 반드시 2 이상)
        return count - 1;
    }

    static boolean[][] visited;

    // 연합이 가능한 도시 갯수 반환
    private static int getOpenCount() {
        // 이미 방문했던 도시
        visited = new boolean[N][N];
        int openCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 도시 bfs 탐색
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    openCount += bfs(i, j);
                }
            }
        }

        return openCount;
    }

    // 연합이 가능한지 확인 (범위 체크, 인구수 차이 확인)
    private static boolean isOpen(int x, int y, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
            return false;
        }

        int peopleDiff = Math.abs(city[x][y] - city[nx][ny]);
        return L <= peopleDiff && R >= peopleDiff;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

