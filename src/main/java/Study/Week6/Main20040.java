package Study.Week6;

import java.io.*;
import java.util.StringTokenizer;

public class Main20040 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int count = 0;
        boolean flag = false;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            count++;
            if(!union(a,b)) {
                flag = true;
                break;
            }
        }

        if(!flag) count = 0;
        System.out.println(count);
    }

    public static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
