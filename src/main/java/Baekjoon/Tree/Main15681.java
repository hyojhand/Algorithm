package Baekjoon.Tree;

import java.io.*;
import java.util.*;
// G5 트리와 쿼리
// 트리 만들기 & 한 정점 아래의 서브쿼리 정점 갯수 구하기
public class Main15681 {
    static List<Integer>[] list, tree;
    static int[] parent, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        count = new int[N+1];
        list = new List[N+1];
        tree = new List[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        for(int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(count[node]).append('\n');
        }

        System.out.println(sb);
    }

    static void makeTree(int currentNode, int p) {
        for(int node : list[currentNode]) {
            if(node != p) {
                tree[currentNode].add(node);
                parent[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }

    static void countSubtreeNodes(int currentNode) {
        count[currentNode] = 1;

        for(int child : tree[currentNode]) {
            countSubtreeNodes(child);
            count[currentNode] += count[child];
        }
    }
}

