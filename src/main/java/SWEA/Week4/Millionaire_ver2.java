package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Millionaire_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc < T) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long result = 0;
            for(int i = N-1; i >= 0; i--) {
                if(max < arr[i]) {
                    max = arr[i];
                }
                else {
                    result += (max - arr[i]);
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);

    }
}
