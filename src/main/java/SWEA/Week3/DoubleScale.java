package SWEA.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class DoubleScale {
    static boolean[] check;
    static int[] arr;
    static int N;
    static int count;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while (tc < T) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            check = new boolean[N];
            count = 0;

            total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total += arr[i];
            }

            for (int i = 0; i < N; i++) {
                check[i] = true;
                find(1, arr[i], 0);
                check[i] = false;
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static void find(int dept, int sum, int right) {
        if (dept == N) {
            count++;
            return;
        }

        if(total - sum < sum) {
            int n = N-dept;
            int num = 1;
            while(n >= 1) {
                num *= n--;
            }
            count += Math.pow(2,N-dept)*num;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                find(dept + 1, sum + arr[i], right);

                if (sum >= right + arr[i]) {
                    find(dept + 1, sum, right + arr[i]);
                }
                check[i] = false;
            }
        }

    }
}
