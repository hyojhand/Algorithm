package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// G4 비밀모임 - 다익스트라를 통해 각 출발지마다의 거리를 계산해서 전체 거리를 더한 후 최소거리의 방을 구한다. (플로이드 워셜로 해결가능)
public class Main13424 {
    static int N;
    static List<Node>[] list;
    static int[] sum_distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list[from].add(new Node(to, weight));
                list[to].add(new Node(from, weight));
            }

            int K = Integer.parseInt(br.readLine());
            int[] friend = new int[K];
            sum_distance = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friend[i] = Integer.parseInt(st.nextToken());
                dijkstra(friend[i]);
            }


            int min = Integer.MAX_VALUE;
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                if(min > sum_distance[i]) {
                    min = sum_distance[i];
                    answer = i;
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static void dijkstra (int start) {
        int[] distance = new int[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, distance[start]));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            for(Node node : list[current.to]) {
                if(distance[node.to] > distance[current.to] + node.weight) {
                    distance[node.to] = distance[current.to] + node.weight;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            sum_distance[i] += distance[i];
        }
    }

    static class Node implements Comparable<Node> {
        int to,weight;
        public Node (int to,int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

