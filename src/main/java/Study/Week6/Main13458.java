package Study.Week6;

import java.io.*;
import java.util.StringTokenizer;

public class Main13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long count = N;
        for(int i = 0; i < N; i++) {
            arr[i] -= B;
            if(arr[i] > 0) {
                if(arr[i]%C == 0) count += (arr[i]/C);
                else count += arr[i]/C+1;
            }
        }
        System.out.println(count);
    }
}

