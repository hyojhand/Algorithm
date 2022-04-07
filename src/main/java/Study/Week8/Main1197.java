package Study.Week8;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1197 {
    static Edge[] edgeList;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        makeSet();

        int count = 0;
        int result = 0;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                count++;
                result += edge.weight;

                if (count == V - 1) break;
            }
        }

        System.out.println(result);
    }

    static int[] parents;
    public static void makeSet() {
        parents = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
