package Study.Week20_24;


import java.io.*;
import java.util.*;
// 촌수계산
public class Main2644 {
    static List<Integer>[] list;
    static int max = -1;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        check = new boolean[N+1];
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(x,y,0);
        System.out.println(max);
    }

    static void dfs(int start, int end, int dept) {
        if(start == end) {
            max = dept;
            return;
        }

        check[start] = true;
        for(int i = 0; i < list[start].size(); i++) {
            int num = list[start].get(i);
            if(!check[num]) {
                dfs(num, end, dept+1);
            }
        }
    }
}

