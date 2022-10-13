package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 해킹 G4
public class Main10282 {
    static int n;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list[from].add(new Node(to, weight));
            }

            int[] distance = dijkstra(start);

            int result = 0;
            int cnt = 0;
            for(int i = 1; i <= n; i++) {
                if(distance[i] != Integer.MAX_VALUE) {
                    cnt++;
                    result = Math.max(distance[i], result);
                }
            }

            sb.append(cnt).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }

    static int[] dijkstra (int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

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
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}
