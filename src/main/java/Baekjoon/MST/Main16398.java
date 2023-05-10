package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G4 행성 연결
// 입력으로 주어진 배열에서 가중치가 0인 자기 자신을 제외한 모든 간선을 리스트에 더해준다.
// 간선 리스트를 최소비용순으로 정렬하고, 루트 배열을 초기화한다.
// 간선 리스트를 반복문으로 탐색하며 union이 가능한 지점을 연결하고 값을 더한다. (path compression 최적화)
// 이때, 가중치의 최대값이 100,000,000 이므로 최종 결과값의 자료형은 long 형으로 사용한다.
public class Main16398 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (weight == 0) {
                    continue;
                }

                nodes.add(new Node(i, j, weight));
            }
        }

        // 최소비용 순으로 정렬
        Collections.sort(nodes);
        makeSet(N);

        long answer = 0;
        for (Node node : nodes) {
            if (union(node.from, node.to)) {
                answer += node.weight;
            }
        }

        System.out.println(answer);
    }

    private static void makeSet(int n) {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int number) {
        if (parents[number] == number) {
            return number;
        }

        // path compression
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

