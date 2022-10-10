package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 최소비용 구하기2 G3
// 지나온 경로 구하기 -> 이전 정점을 배열에 저장해 놓고 stack에 마지막 정점부터 담으면서 다시 꺼낸다
public class Main11779 {
    static List<Node>[] list;
    static int n;
    static int[] preCity;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append('\n');

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int count = 1;
        while(preCity[end] != 0) {
            stack.push(preCity[end]);
            count++;
            end = preCity[end];
        }

        sb.append(count).append('\n');

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static int[] dijkstra(int start) {
        int[] distance = new int[n+1];
        boolean[] visit = new boolean[n+1];
        preCity = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(visit[current.to]) continue;
            visit[current.to] = true;

            for(Node node : list[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    preCity[node.to] = current.to;
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
