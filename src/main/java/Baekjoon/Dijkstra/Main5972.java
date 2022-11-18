package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// G5 택배배송
public class Main5972 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,weight));
            list[to].add(new Node(from,weight));
        }

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            for(Node node : list[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        System.out.println(distance[N]);
    }


    static class Node implements Comparable<Node> {
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
