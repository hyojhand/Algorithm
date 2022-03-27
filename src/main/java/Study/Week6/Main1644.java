package Study.Week6;

import java.io.*;

public class Main1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[N + 1];
        int[] arr = new int[N+1];
        int idx = 0;
        int size = 0;

        for (int i = 2; i <= N; i++) {
            if (!check[i]) {
                arr[idx] = i;
                idx++;
                size++;
                for (int k = i; k <= N; k += i) check[k] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            int k = i;
            while (true) {
                sum += arr[k];
                if (sum > N) break;
                if (sum == N) {
                    count++;
                    break;
                }
                if(k > size) break;
                k++;
            }
        }

        System.out.println(count);

    }
}
