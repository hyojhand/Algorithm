package Study.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
    static boolean[] check;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        arr = new int[M];

        func(N,M,0);

        System.out.println(sb);

    }

    static void func(int N,int M, int dept) {
        if(dept == M) {
            for(int n:arr) {
                sb.append(n).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[dept] = i+1;
                func(N,M,dept+1);
                check[i] = false;
            }
        }

    }

}
