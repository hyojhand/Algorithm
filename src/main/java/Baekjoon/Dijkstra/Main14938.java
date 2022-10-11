package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 서강그라운드 G4
public class Main14938 {
    static int n,m;
    static int[] item;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        item = new int[n+1];
        for(int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            int count = dijkstra(i);
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static int dijkstra(int start) {
        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
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

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(distance[i] <= m) sum += item[i];
        }

        return sum;
    }


    static class Node implements Comparable<Node>{
        int to,weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
}
