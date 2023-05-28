package Baekjoon.MST;

import java.io.*;
import java.util.*;

// G3 나만 안되는 연애
// 기존의 MST 문제에서 성별이 다른 대상만 연결할 수 있는 조건이 추가되었다.
// 해당 지점의 성별을 따로 관리하는 배열을 통해, 두 지점을 union 하기전에 다른 성별인지 먼저 확인해주는 조건을 추가한다.
// 모든 지점을 연결하지 못했다면 -1 반환
public class Main14621 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] gender = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken();
        }

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.add(new Node(from, to, weight));
        }

        // 최소비용 순으로 정렬
        Collections.sort(nodes);
        makeSet(N);

        int answer = 0;
        int count = 0;
        for (Node node : nodes) {
            if (!gender[node.from].equals(gender[node.to]) && union(node.from, node.to)) {
                answer += node.weight;
                count++;
            }
        }

        // 모두 연결하지 못하면 -1
        answer = count == N - 1 ? answer : -1;
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

