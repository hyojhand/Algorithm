package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G1 다리 만들기 2
// BFS, DFS, MST로 구현한 문제이다.
// 1) 입력으로 주어진 배열에서 각 섬을 번호로 구분해준다.
// BFS를 활용해 4방 탐색으로 연결된 섬에 같은 번호를 부여한다.
// 섬은 최대 6개이므로, 6개의 Point 객체 리스트 배열을 생성해 각 섬의 번호에 해당하는 배열에 좌표(Point) 리스트를 넣는다.

// 2) 모든 섬에서 연결 가능한 섬 찾기
// 각 섬의 모든 좌표를 4방향을 일직선으로 탐색하며 다른 번호를 가진 섬과 만나는지 확인한다.
// 4방향으로 DFS를 통해 입력의 배열을 넘어가지 않는 다른 번호의 섬을 찾는다.
// 이때, 거리는 2이상이어야 하며, 만족하는 조건의 섬을 찾으면 연결가능한 Node 객체리스트에 연결할 두 섬의 번호와 거리를 넣는다.

// 3) MST 최소 비용을 구한다.
// 가지고 있는 모든 경로를 크루스칼 알고리즘으로 MST를 구성하고, 최소 비용을 구한다.
// 이때 연결한 경로의 수가 (섬의 개수 - 1)을 만족하지 못하면 MST를 구성하지 못하므로 -1을 반환한다.

// 문제 조건을 제대로 읽지않아 시간이 오래걸렸다.
// 1. 테스트 케이스보다 더 짧은 거리로 반환했는데, 거리 2 이상만 포함하는 조건을 놓치고 있었다.
// 2. 처음 구현할 때는 섬 객체를 만들었다.(Island, 섬의 좌상단 좌표와 행,열의 크기를 가지는 섬 객체)
// 섬은 당연히 직사각형이라고 생각했는데, 아래의 다른 테스트 케이스에서 섬의 모양이 무조건 사각형이 아닌 단순 연결된 형태도 있어 사용할 수 없게 되었다.
// 구현해야하는 조건을 제대로 확인하고 구현하자!
public class Main17472 {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] board;
    // 모든 섬을 탐색하며 다리 연결이 가능한 간선을 등록
    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력받은 배열
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬은 최대 6개이므로, 각 섬의 좌표를 가지는 리스트 배열 초기화
        List<Point>[] islands = new List[7];
        for (int i = 0; i <= 6; i++) {
            islands[i] = new ArrayList<>();
        }

        // 섬의 번호 갱신
        int islandNumber = 1;
        // 방문 여부 체크
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 방문하지 않은 섬이라면, 섬 리스트에 넣기
                if (!visited[i][j] && board[i][j] == 1) {

                    // 해당 섬의 좌표 리스트를 배열에 넣기
                    List<Point> islandPoints = findIslandPoints(islandNumber, i, j, visited);
                    islands[islandNumber] = islandPoints;
                    islandNumber++;
                }
            }
        }

        // 모든 섬에서 연결가능한 섬 찾기
        for (List<Point> island : islands) {
            // 해당 섬에서 다른 섬을 만나는지 확인
            for (Point point : island) {
                checkConnect(point);
            }
        }

        // 현재 섬의 개수만큼 MST 비용 확인
        int answer = kruskal(islandNumber - 1);
        System.out.println(answer);
    }

    // BFS 활용 가능한 섬의 좌표 리스트 찾기
    private static List<Point> findIslandPoints(int islandNumber, int x, int y, boolean[][] visited) {
        List<Point> points = new ArrayList<>();

        // 해당 번호로 섬의 번호를 갱신
        board[x][y] = islandNumber;
        visited[x][y] = true;

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        while (!que.isEmpty()) {
            Point p = que.poll();

            // 섬 좌표 추가
            points.add(new Point(p.x, p.y));

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    board[nx][ny] = islandNumber;
                    que.offer(new Point(nx, ny));
                }
            }
        }

        return points;
    }

    // 연결 가능한 다른 섬 확인
    static private void checkConnect(Point point) {
        int islandNumber = board[point.x][point.y];
        // 4방 탐색으로 다른 섬을 만날 때까지 DFS
        for (int dir = 0; dir < 4; dir++) {
            dfs(islandNumber, point.x, point.y, dir, 0);
        }
    }

    private static void dfs(int number, int x, int y, int dir, int distance) {
        // 0이아닌 다른 섬을 만나면 이전까지의 거리를 비용으로 간선 추가
        if (board[x][y] != 0 && board[x][y] != number) {
            // 섬을 도착하기 전까지의 거리가 2이상이면 추가
            if (distance - 1 >= 2) {
                nodes.add(new Node(number, board[x][y], distance - 1));
            }
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 전체 범위내에서 같은 섬이 아니라면 DFS
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] != number) {
            dfs(number, nx, ny, dir, distance + 1);
        }
    }

    private static int kruskal(int islandSize) {
        DisjointSet disjointSet = new DisjointSet(islandSize);
        Collections.sort(nodes);

        int answer = 0;
        int count = 0; // 연결한 개수
        for (Node node : nodes) {
            if (disjointSet.union(node.from, node.to)) {
                answer += node.weight;
                count++;
            }
        }

        // 모두 연결하지 못하면 -1 반환
        return count == islandSize - 1 ? answer : -1;
    }

    static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
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

        private int findSet(int number) {
            if (parents[number] == number) {
                return number;
            }

            return parents[number] = findSet(parents[number]);
        }

        private boolean union(int a, int b) {
            int aRoot = findSet(a);
            int bRoot = findSet(b);

            if (aRoot == bRoot) {
                return false;
            }

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

