package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 백도어 G5 - visit체크 , distance long형
public class Main17396 {
    static List<Node>[] list;
    static int[] see;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        see = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            see[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

        long result = dijkstra(N);
        System.out.println(result);
    }

    static long dijkstra (int N) {
        long[] distance = new long[N];
        boolean[] visit = new boolean[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(visit[current.to]) continue;
            visit[current.to] = true;

            for (Node node : list[current.to]) {
                if(see[node.to] == 0 || node.to == N-1) {
                    if (distance[node.to] > distance[current.to] + node.weight) {
                        distance[node.to] = distance[current.to] + node.weight;
                        pq.offer(new Node(node.to, distance[node.to]));
                    }
                }
            }
        }

        if(distance[N-1] == Long.MAX_VALUE) return -1;
        else return distance[N-1];
    }

    static class Node implements Comparable<Node> {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight - o.weight > 0) return 1;
            else return -1;
        }
    }
}
