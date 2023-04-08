package Baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// G4 최소 스패닝 트리
// Kruskal 알고리즘, union find 활용
public class Main1197 {
    static int V, E;
    static int[] parents;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 간선을 가지는 배열
        nodes = new Node[E];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(from, to, weight);
        }

        // 간선비용 오름차순 정렬
        Arrays.sort(nodes);

        makeSet();

        int answer = 0;
        int count = 0;

        // 사이클이 존재하는지 확인하면서 최소비용 순으로 연결
        for(Node node : nodes) {
            // 사이클이 존재하지 않으면(union이 성공하면) 간선 연결
            if(union(node.from, node.to)) {
                count++;
                answer += node.weight;
            }

            // 모든 지점을 방문했으면 break;
            if(count == V - 1) break;
        }

        System.out.println(answer);
    }

    // 단위집합 생성
    private static void makeSet() {
        parents = new int[V + 1];
        // 자신의 부모노드를 자신의 값으로 세팅
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    // number 대표자(루트) 찾기
    private static int findSet(int number) {
        // 자신이 부모와 같다 = 자신이 루트이다.
        if(number == parents[number]) {
            return number;
        }

        // path compression 루트노드의 번호를 재귀로 찾아와서 나의 부모로 대체한다.
        return parents[number] = findSet(parents[number]);
    }

    // a,b 두 집합 합치기
    private static boolean union(int a,int b) {
        // 두 집합의 대표자(루트) 찾기
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        // 둘이 같은 집합이면 합칠 수 없다.
        if(aRoot == bRoot) {
            return false;
        }

        // a밑에 b붙이기
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
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
