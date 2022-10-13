package Baekjoon.Dijkstra;

import java.io.*;
import java.util.*;
// 달빛 여우 G1 / double형 계산을 없애기위해 미리 x2 해주기, 달빛늑대는 홀짝번을 구분하기위해 2차원배열로 생성,
// 다익스트라 pq에 넣기전에 이미 최단거리가 아닐경우 continue 시켜주기
public class Main16118 {
    static List<Node>[] list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight*2));
            list[to].add(new Node(from, weight*2));
        }

        long[] fox = findFox();
        long[][] wolf = findWolf();

        int result = 0;
        for(int i = 1; i <= N; i++) {
            long min = Math.min(wolf[0][i], wolf[1][i]);
            if(fox[i] < min) result++;
        }

        System.out.println(result);
    }

    static long[][] findWolf () {
        int start = 1;
        long[][] distance = new long[2][N + 1];
        Arrays.fill(distance[0], Long.MAX_VALUE);
        Arrays.fill(distance[1], Long.MAX_VALUE);
        distance[1][start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int fast = current.fast;

            if(distance[fast][current.to] < current.weight) continue;

            for (Node node : list[current.to]) {
                long weight = node.weight;
                if(fast % 2 != 0) weight /= 2;
                else weight *= 2;

                int next_fast = 1 - fast;

                if (distance[next_fast][node.to] > distance[fast][current.to] + weight) {
                    distance[next_fast][node.to] = distance[fast][current.to] + weight;
                    pq.offer(new Node(next_fast,node.to, distance[next_fast][node.to]));
                }
            }
        }

        return distance;
    }

    static long[] findFox () {
        int start = 1;
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(distance[current.to] < current.weight) continue;

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
        int fast,to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        public Node(int fast,int to, long weight) {
            this.fast = fast;
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
