package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;

// 파티 G3
// 파티장소까지 최단거리 = 정점까지 다익스트라 1번 + 돌아오는 최단거리 = 간선 뒤집어서 다익스트라 1번
public class Main1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N+1];
        List<Node>[] list2 = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,weight));
            list2[to].add(new Node(from,weight));
        }

        int[] distance = new int[N+1];
        int[] distance2 = new int[N+1];

        distance = dijkstra(distance, list, N, X);
        distance2 = dijkstra(distance2, list2, N, X);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, distance[i]+distance2[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(int[] distance, List<Node>[] list,int N, int X) {
        boolean[] visit = new boolean[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, distance[X]));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(visit[current.to]) continue;
            visit[current.to] = true;

            for(Node node : list[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node>{
        int to,weight;
        public Node(int to,int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
