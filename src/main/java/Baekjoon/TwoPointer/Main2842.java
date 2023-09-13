package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

// P4 집배원 한상덕
// 무조건 방문해야 하는 우체국과 집의 고도 중 최소,최대값을 구한다. (minHeight, maxHeight)
// 방문할 수 있는 모든 고도의 배열을 오름차순으로 정렬하고, 고도의 최소,최대 사이의 범위만 방문할 수 있게 한다.
// 모든 집을 방문한다면, 최소값을 올려 다시 BFS 탐색하여 (최대-최소)의 차이를 줄이고,
// 모든 집을 방문할 수 없다면 최대값을 늘려 모든 집을 방문할 수 있도록 한다.
// 투 포인터의 시작은 left = 0, right = maxHeight로 지정한다.
// BFS 탐색간에 left번째의 고도와 right번째의 고도 사이가 아니라면 탐색하지 않는다.
public class Main2842 {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int left, right, houseCount = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] places = new char[N][N];
        Point start = null;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char place = input.charAt(j);
                places[i][j] = place;

                if (place == 'P') {
                    start = new Point(i, j);
                }

                if (place == 'K') {
                    houseCount++;
                }
            }
        }

        // 각 위치의 고도를 가지는 배열
        int[][] heights = new int[N][N];
        // 중복되지 않는 고도 모음
        HashSet<Integer> heightSet = new HashSet<>();

        // 무조건 방문해야 하는 우체국과 집의 고도 중 최소,최대값을 구한다. (minHeight, maxHeight)
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());

                heights[i][j] = height;
                heightSet.add(height);

                char place = places[i][j];
                if (place == 'P' || place == 'K') {
                    minHeight = Math.min(minHeight, height);
                    maxHeight = Math.max(maxHeight, height);
                }
            }
        }

        // 방문할 수 있는 모든 고도의 배열
        int[] allHeights = new int[heightSet.size()];
        int index = 0;
        Iterator<Integer> iterator = heightSet.iterator();
        while (iterator.hasNext()) {
            allHeights[index] = iterator.next();
            index++;
        }
        // 오름차순으로 정렬
        Arrays.sort(allHeights);

        int leftMax = 0; // left가 leftMax보다 커지면 우체국,집의 고도 중 방문할 수 없는 곳이 생긴다.
        // right는 최대 고도값으로 시작한다.
        for (int i = 0; i < allHeights.length; i++) {
            if (minHeight == allHeights[i]) leftMax = i;
            if (maxHeight == allHeights[i]) right = i;
        }

        int answer = Integer.MAX_VALUE;
        // left는 우체국,집의 최대 고도를 넘지않고, right는 모든 고도의 범위를 넘지 않는 선에서 최소 간격을 구한다.
        while (left <= right && right < allHeights.length && left <= leftMax) {
            if (bfs(start, heights, allHeights, places)) {
                // 모든 집을 탐색했다면 최소간격을 구하고, left를 ++하여 간격을 줄여 다시 BFS
                answer = Math.min(answer, allHeights[right] - allHeights[left]);
                left++;
            } else {
                // 모든 집을 탐색하지 못했다면 right 간격을 늘려 다시 BFS
                right++;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(Point start, int[][] heights, int[] allHeights, char[][] places) {
        Queue<Point> que = new LinkedList<>();

        boolean[][] visited = new boolean[N][N];
        visited[start.x][start.y] = true;
        que.offer(start);

        int count = 0;
        while (!que.isEmpty()) {
            Point point = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                // 범위 벗어나면 continue
                if (isOutOfBound(nx, ny)) {
                    continue;
                }

                // 고도 범위를 벗어나면 continue
                if (heights[nx][ny] < allHeights[left] ||
                        heights[nx][ny] > allHeights[right]) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.offer(new Point(nx, ny));

                    if (places[nx][ny] == 'K') {
                        count++;
                    }
                }
            }
        }

        // 모든 집을 방문했는지 반환
        return count == houseCount;
    }

    private static boolean isOutOfBound(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
