package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G3 학교 탐방하기
// 모두 이어지는 경로를 구해야하기에 MST로 접근하고, 최대값 - 최소값을 구하는과정에서
// 가장 높은 피로도는 오르막길을 최대한 많이 지나간 경로이고, 가장 낮은 피로도는 오르막길을 최대한 적게 지나간 경로이다.
// 오르막길 우선 정렬한 배열과 내리막길 우선 정려한 배열로 크루스칼 알고리즘으로 오르막길의 개수를 세고,
// 각 제곱한 값을 빼서 최종 값을 반환한다.
public class Main13418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[M + 1];
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(from, to, dir);
        }

        // 오르막길 우선 정렬
        Arrays.sort(nodes, (o1, o2) -> o1.dir - o2.dir);
        int maxFatigue = (int) Math.pow(kruskal(N, nodes), 2);

        // 내리막길 우선 정렬
        Arrays.sort(nodes, (o1, o2) -> o2.dir - o1.dir);
        int minFatigue = (int) Math.pow(kruskal(N, nodes), 2);

        System.out.println(maxFatigue - minFatigue);
    }

    private static int kruskal(int N, Node[] nodes) {
        DisjointSet disjointSet = new DisjointSet(N);
        int ascentCount = 0;
        for (Node node : nodes) {
            if (disjointSet.union(node.from, node.to)) {
                if (node.dir == 0) {
                    ascentCount++;
                }
            }
        }

        return ascentCount;
    }

    static class DisjointSet {
        int[] parents;

        public DisjointSet(int N) {
            parents = new int[N + 1];
            for (int i = 0; i <= N; i++) {
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

    static class Node {
        int from, to, dir;

        public Node(int from, int to, int dir) {
            this.from = from;
            this.to = to;
            this.dir = dir;
        }
    }

}
