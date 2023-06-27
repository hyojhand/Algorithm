package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;

// G4 가장 먼 곳
public class Main22865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        // 간선 저장 리스트
        List<Node>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

        // A, B, C 에서 시작하는 모든 지점까지의 최단거리 배열
        int[] distanceA = dijkstra(A, N, list);
        int[] distanceB = dijkstra(B, N, list);
        int[] distanceC = dijkstra(C, N, list);

        // 거리 최대값
        int maxDistance = 0;
        // 지점 번호
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            // 각 지점에서 시작하는 최단거리 최소값
            int min = Math.min(distanceA[i], Math.min(distanceB[i], distanceC[i]));

            // 가장 먼 곳이라면 정답 갱신
            if (maxDistance < min) {
                maxDistance = min;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    static private int[] dijkstra(int X, int N, List<Node>[] list) {
        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node node : list[current.to]) {
                if (distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
}

