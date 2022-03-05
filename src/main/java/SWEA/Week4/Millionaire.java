package SWEA.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class Millionaire {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc < T) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            int count = 0;
            long sum = 0;
            long result = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i] == max) {
                    result += ((long) arr[i] *count - sum);
                    count = 0;
                    sum = 0;
                    max = Integer.MIN_VALUE;
                    for(int j = i+1; j < N; j++) {
                        max = Math.max(max,arr[j]);
                    }
                }
                else {
                    if(i == N-1) {
                        break;
                    }
                    count++;
                    sum += arr[i];
                }
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);

    }
}
