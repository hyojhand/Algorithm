package Study.Week9;

import java.io.*;
import java.util.StringTokenizer;
// 회전초밥
public class Main15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] check = new int[d+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 1;
        check[coupon]++;
        for(int i = 0; i < k; i++) {
            if(check[arr[i]] == 0) count++;
            check[arr[i]]++;
        }

        int max = count;
        for(int i = 0; i < N; i++) {
            check[arr[i]]--;
            if(check[arr[i]] == 0) count--;

            check[arr[k]]++;
            if(check[arr[k]] == 1) count++;

            k++;
            if(k % N == 0) k = 0;
            max = Math.max(count,max);
        }

        System.out.println(max);

    }
}


