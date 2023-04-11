package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;

// G3 택배
// 각 지점을 시작점으로 다익스트라 최단거리 계산
// 해당 지점까지 최단거리로 도착하기 위해 처음 지나야할 지점을 저장하는 배열을 최단거리가 갱신될 때마다 함께 갱신
public class Main1719 {
    // 경로를 가지는 리스트
    static List<Node>[] nodes;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        // 경로 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight));
            nodes[to].add(new Node(from, weight));
        }

        // n번의 다익스트라로 각 시작점의 최단거리를 거치기 위해 지나야하는 경로 배열 탐색
        int[][] answer = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            answer[i] = dijkstra(i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 시작점은 "-"
                if (i == j) {
                    result.append("-");
                } else {
                    result.append(answer[i][j]);
                }

                result.append(" ");
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    private static int[] dijkstra(int start) {
        // 최단거리 배열
        int[] distance = new int[n + 1];
        // 해당 지점까지 최단거리로 도착하기 위해 처음 지나야할 지점을 저장하는 배열
        int[] memory = new int[n + 1];
        // 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            memory[i] = i;
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        // 다익스트라 최단경로 탐색
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node node : nodes[current.to]) {
                if (distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));

                    // 시작점 바로 다음이 아니라면, 최단거리 갱신시 지나와야할 지점을 갱신
                    if (current.to != start) {
                        memory[node.to] = memory[current.to];
                    }
                }
            }
        }
        return memory;
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
