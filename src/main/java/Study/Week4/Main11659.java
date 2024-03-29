package Study.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[b]-arr[a-1]).append('\n');
        }

        System.out.println(sb);

    }
}
