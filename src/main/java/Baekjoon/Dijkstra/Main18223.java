package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
//G4 민준이와 마산 그리고 건우
public class Main18223 {
    static List<Node>[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        route = new ArrayList[V+1];

        for(int i = 1; i <= V; i++) {
            route[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            route[from].add(new Node(to,weight));
            route[to].add(new Node(from,weight));
        }

        int directResult = dijkstra(1,V,V);
        int saveResult = dijkstra(1,P,V) + dijkstra(P,V,V);

        if(directResult == saveResult) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");

    }

    static int dijkstra(int start,int end,int V) {
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(current.to == end) return distance[end];

            for(Node node: route[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        return distance[end];
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

