package Study.Week20_24;

import java.io.*;
import java.util.*;
// 행성 터널
public class Main2887 {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Point(i,a,b,c);
        }

        ArrayList<Edge> list = new ArrayList<>();

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        for(int i = 1; i < N; i++) {
            list.add(new Edge(arr[i-1].num, arr[i].num, Math.abs(arr[i-1].x - arr[i].x)));
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        for(int i = 1; i < N; i++) {
            list.add(new Edge(arr[i-1].num, arr[i].num, Math.abs(arr[i-1].y - arr[i].y)));
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.z - o2.z;
            }
        });

        for(int i = 1; i < N; i++) {
            list.add(new Edge(arr[i-1].num, arr[i].num, Math.abs(arr[i-1].z - arr[i].z)));
        }

        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        parents = new int[N];
        for(int i =0; i < N; i++) {
            parents[i] = i;
        }

        long result = 0;
        for(int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);

            if(find(e.from) != find(e.to)) {
                result += e.weight;
                union(e.from, e.to);
            }
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if(x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static boolean union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge {
        int from,to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class Point {
        int num,x,y,z;
        public Point(int num, int x,int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}