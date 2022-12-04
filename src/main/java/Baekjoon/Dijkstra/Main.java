package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,1));
        }

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for(Node node : list[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }


        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(distance[i] == K) que.offer(i);
        }

        if(que.isEmpty()) System.out.println(-1);
        else {
            while(!que.isEmpty()) {
                System.out.println(que.poll());
            }
        }

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
