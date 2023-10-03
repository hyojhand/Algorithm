package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;

// P5 거의 최단 경로
// 처음 다익스트라로 최단 경로를 구하는데, 최단 경로의 길이와 같은 경로는 리스트로, 최소값이되면 새로 갱신하여 부모 지점의 리스트를 추가해준다.
// 이후, 최단 경로에 해당하는 마지막 지점부터 백트래킹을 통해 2차원 배열로 경로를 방문 체크해준다.
// 2번째 다익스트라에서는 방문 체크된 경로를 제외한 최단 경로를 구하여 거의 최단 경로를 구할 수 있다.
public class Main5719 {

    static int[] distance;
    static List<Node>[] nodes;
    static boolean[][] checked;
    static List<Integer>[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());


            nodes = new List[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes[from].add(new Node(to, weight));
            }

            distance = new int[N];
            checked = new boolean[N][N];

            parents = new List[N];
            for (int i = 0; i < N; i++) {
                parents[i] = new ArrayList<>();
            }

            dijkstra(S);
            backtracking(S, D);
            dijkstra(S);

            if (distance[D] == Integer.MAX_VALUE) {
                distance[D] = -1;
            }

            result.append(distance[D]).append('\n');
        }

        System.out.println(result);
    }


    private static void dijkstra(int S) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node node : nodes[current.to]) {
                if (checked[current.to][node.to]) continue;

                int dist = distance[current.to] + node.weight;

                if (distance[node.to] == dist) {
                    parents[node.to].add(current.to);
                } else if (distance[node.to] > dist) {
                    distance[node.to] = dist;
                    parents[node.to].clear();
                    parents[node.to].add(current.to);
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }
    }

    private static void backtracking(int S, int node) {
        if (node == S) return;

        for (int number : parents[node]) {

            if (!checked[number][node]) {
                checked[number][node] = true;
                backtracking(S, number);
            }
        }
    }

    static class Node implements Comparable<Node> {
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
