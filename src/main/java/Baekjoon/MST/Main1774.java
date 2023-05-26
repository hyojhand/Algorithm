package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G3 우주신과의 교감
// 먼저, 좌표 객체 Point 배열에 입력으로 주어지는 신의 순서에 맞게 좌표를 저장한다.
// 이후 주어지는 이미 연결된 경로는 루트 배열을 만들어 union 시켜준다.
// 다음으로 MST를 구성하기 위해 최소 비용의 경로 순으로 연결해야하는데, 모든 지점의 개수가 1000개 이므로 2중 for문을 사용해서 모든 경로를 구한다.
// 이미 연결되어있는 지점을 제외한 모든 경로를 리스트에 저장하며, 이때 비용은 두 좌표 사이의 거리이다.
// 경로를 비용 기준 오름차순으로 정렬하고, 크루스칼 알고리즘을 사용해 MST를 구성하며 사용된 비용을 더한다.
// 최종 결과로 소수점 둘째자리까지 값을 출력한다.
public class Main1774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Point[] gods = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gods[i] = new Point(x, y);
        }

        // 루트 배열 생성
        DisjointSet disjointSet = new DisjointSet(N);

        // 연결된 통로 union
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            disjointSet.union(from, to);
        }

        // 연결해야할 간선 리스트
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 두 지점이 연결되어있지 않다면 둘의 거리를 비용으로하는 간선 추가
                if (disjointSet.findSet(i) != disjointSet.findSet(j)) {
                    nodes.add(new Node(i, j, gods[i].getDistance(gods[j])));
                }
            }
        }

        // 비용 오름차순 정렬
        Collections.sort(nodes);

        double answer = kruskal(nodes, disjointSet);
        System.out.printf("%.2f", answer);
    }

    private static double kruskal(List<Node> nodes, DisjointSet disjointSet) {
        double answer = 0;

        for (Node node : nodes) {
            if (disjointSet.union(node.from, node.to)) {
                answer += node.weight;
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int from, to;
        double weight;

        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight) {
                return 1;
            }

            return -1;
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

        private double getDistance(Point otherPoint) {
            return Math.sqrt(Math.pow(Math.abs(this.x - otherPoint.x), 2) + Math.pow(Math.abs(this.y - otherPoint.y), 2));
        }
    }
}

