package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G4 도시 분할 계획 - MST
// 간선을 가지는 배열을 생성하고, 비용을 기준으로 오름차순으로 정렬한다.
// 루트 배열을 초기화해주고, 둘이 union이 가능하다면(연결되지 않았으면) 연결하면서 가중치를 더해준다.
// 마을을 2개로 나누기 때문에, 최소비용으로 나누기 위해 가장 큰 비용 간선 하나를 제외시켜준다.
// 이때, 크루스칼 알고리즘으로 최소비용순으로 간선을 연결하기 때문에 마지막 간선의 가중치를 제외시켜준다.
// union find 최적화 - path compression 으로 시간초과를 해결하는게 중요
public class Main1647 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to, weight);
        }

        // 오름차순 정렬
        Arrays.sort(nodes);

        // 루트 배열 초기화
        makeSet(N);

        int answer = 0;
        int maxWeight = 0;
        for (Node node : nodes) {
            if (union(node.from, node.to)) {
                answer += node.weight;
                maxWeight = Math.max(maxWeight, node.weight);
            }
        }

        System.out.println(answer - maxWeight);
    }

    private static void makeSet(int N) {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int number) {
        if (parents[number] == number) {
            return number;
        }

        return parents[number] = findSet(parents[number]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }

    static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
}

