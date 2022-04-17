package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 집합의 표현
public class Main1717 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        while(m > 0) {
            st = new StringTokenizer(br.readLine());
            int func = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(func == 0) union(a,b);
            else {
                if(find(a) == find(b)) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
            m--;
        }

        System.out.println(sb);
    }

    public static int find(int a) {
        if(a == parents[a]) return a;

        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parents[bRoot] = aRoot;
    }
}
