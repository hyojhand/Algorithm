package Baekjoon.Dijkstra.BellmanFord;

import java.io.*;
import java.util.*;
// G4 타임머신 - 음수 가중치이기 때문에 벨만포드 알고리즘 사용
// (정점 - 1)번의 매 단계마다 모든 간선을 전부 확인하면서 모든 노드간의 최단 거리를 구해나간다.
// 마지막으로 한번 더 모든 간선의 최단거리를 확인하고, 다시 초기화하는 곳이 있다면 이는 음수 순회가 있는 곳
// 음수 가중치로 인해 underflow가 발생할 수 있어서 거리를 long으로 저장해야한다.
public class Main11657 {
    static int N, M;
    static long[] distance;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, weight));
        }

        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean isCycle = bellmanFord();

        StringBuilder sb = new StringBuilder();
        if (isCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) sb.append(-1).append('\n');
                else sb.append(distance[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    static boolean bellmanFord() {
        int start = 1;
        distance[start] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Node node = list.get(j);
                if (distance[node.from] != Integer.MAX_VALUE && distance[node.to] > distance[node.from] + node.weight) {
                    distance[node.to] = distance[node.from] + node.weight;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            Node node = list.get(j);
            if (distance[node.from] != Integer.MAX_VALUE && distance[node.to] > distance[node.from] + node.weight) {
                distance[node.to] = distance[node.from] + node.weight;
                return true;
            }
        }

        return false;
    }

    static class Node {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
