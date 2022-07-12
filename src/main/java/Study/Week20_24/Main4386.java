package Study.Week20_24;

import java.io.*;
import java.util.*;
// 별자리 만들기
public class Main4386 {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point[] arr = new Point[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            arr[i] = new Point(a,b);
        }

        ArrayList<Edge> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {

                double distance = Math.sqrt(Math.pow(arr[i].x - arr[j].x, 2) + Math.pow(arr[i].y - arr[j].y, 2));
                list.add(new Edge(i,j, Math.round(distance * 100)/100.0));
            }
        }

        Collections.sort(list);

        parents = new int[N];
        for(int i =0; i < N; i++) {
            parents[i] = i;
        }

        double result = 0;
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

    static class Edge implements Comparable<Edge>{
        int from,to;
        double weight;
        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight > o.weight) return 1;
            return -1;
        }
    }

    static class Point {
        double x,y;
        public Point(double x,double y) {
            this.x = x;
            this.y = y;
        }
    }
}
