package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G3 정복자
// MST 문제로 부모 노드를 초기화해주고, 노드는 비용이 적은 순으로 정렬해준다.
// union 메서드가 가능하면 비용을 더해주며 연결해 MST를 만든다.
// 이때, 각 회차별로 t를 곱해서 비용을 추가해준다.
public class Main14950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.add(new Node(from, to, weight));
            nodes.add(new Node(to, from, weight));
        }

        DisjointSet disjointSet = new DisjointSet(N);
        Collections.sort(nodes);

        int answer = 0;
        int count = 0;

        for (Node node : nodes) {
            if (disjointSet.union(node.from, node.to)) {
                answer += (node.weight + (count * t));
                count++;
            }
        }

        System.out.println(answer);
    }

    public static class DisjointSet {
        int[] parents;

        public DisjointSet(int N) {
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }
        }

        private int findSet(int number) {
            if (number == parents[number]) {
                return number;
            }

            return parents[number] = findSet(parents[number]);
        }

        private boolean union(int a, int b) {
            int aRoot = findSet(a);
            int bRoot = findSet(b);

            if (aRoot == bRoot) {
                return false;
            }

            parents[bRoot] = aRoot;
            return true;
        }
    }

    public static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

