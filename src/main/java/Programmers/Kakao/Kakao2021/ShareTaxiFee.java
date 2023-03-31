package Programmers.Kakao.Kakao2021;

import java.util.*;

// 2021 KAKAO BLIND RECRUITMENT - 합승 택시 요금
// 모든 지점에서 다익스트라하고, 특정 환승지점에서 a까지 거리 + b까지 거리 + 시작점거리 최소값을 구하려하니 - 7,8,22 테케 시간초과
// S, A, B 지점을 출발지점으로 구하고, 모든 지점에서 S까지 거리 + A까지 거리 + B까지의 거리로 최소값을 구하자!
public class ShareTaxiFee {

    public int solution(int n, int s, int a, int b, int[][] fares) {

        // 경로 저장 리스트
        List<Node>[] route = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            route[i] = new ArrayList<>();
        }

        // 경로 양방향 저장
        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];

            route[from].add(new Node(to, weight));
            route[to].add(new Node(from, weight));
        }

        int answer = Integer.MAX_VALUE;

        // S,A,B에서의 다익스트라
        int[] distanceToS = dijkstra(route, s, n);
        int[] distanceToA = dijkstra(route, a, n);
        int[] distanceToB = dijkstra(route, b, n);
        for (int i = 1; i <= n; i++) {
            // 특정 환승지점에서 a까지 거리 + b까지 거리 + 시작점거리 최소값
            answer = Math.min(answer, distanceToS[i] + distanceToA[i] + distanceToB[i]);
        }

        return answer;
    }

    private int[] dijkstra(List<Node>[] route, int start, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node node : route[current.to]) {
                if (distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        return distance;
    }

    class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
