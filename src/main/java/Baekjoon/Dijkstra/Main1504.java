package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 특정한 최단 경로 G4
public class Main1504 {
    static int N;
    static ArrayList<Node>[] list;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,weight));
            list[to].add(new Node(from,weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int start = 1;

        int[] distance1 = dijkstra(start);
        int[] distance2 = dijkstra(v1);
        int[] distance3 = dijkstra(v2);

        int result = Math.min(distance1[v1] + distance2[v2] + distance3[N], distance1[v2] + distance3[v1] + distance2[N]);

        if(result >= INF) System.out.println(-1);
        else System.out.println(result);
    }

    static int[] dijkstra(int start) {
        int[] distance = new int[N+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

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
