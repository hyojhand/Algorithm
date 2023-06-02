package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G3 판게아1
// T 만큼의 테스트 케이스를 반복해서 각 줄마다 최종결과를 출력한다.
// MST 문제로, 최초의 간선을 저장해놓고 각 간선이 추가될 때마다 최소비용 순으로 정렬한 이후, MST 비용을 계산한다.
// MST 비용을 계산할 때마다 XOR 연산을 거듭해 최종 결과를 구한다.
// 간선의 가중치가 최대 10,000,000 이므로 long 형으로 사용함에 주의해야한다.
public class Main10723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 최초 세계에 연결되는 간선 정보 입력
            List<Node> nodes = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes.add(new Node(i, to, weight));
            }

            long answer = 0;

            // 간선을 하나씩 입력받을 때 마다 MST 계산
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes.add(new Node(from, to, weight));

                Collections.sort(nodes);

                // XOR 연산
                answer = answer ^ kruskal(N, nodes);
            }

            T--;
            result.append(answer).append('\n');
        }

        System.out.println(result);
    }

    private static long kruskal(int N, List<Node> nodes) {
        DisjointSet disjointSet = new DisjointSet(N);

        long sum = 0;
        for (Node node : nodes) {
            if (disjointSet.union(node.from, node.to)) {
                sum += node.weight;
            }
        }

        return sum;
    }

    static class DisjointSet {
        int[] parents;

        public DisjointSet(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int findSet(int number) {
            if (parents[number] == number) {
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
