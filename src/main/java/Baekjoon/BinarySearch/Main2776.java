package Baekjoon.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 암기왕 S4
public class Main2776 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc < T) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                boolean check = find(num);
                if(check) sb.append(1);
                else sb.append(0);

                sb.append('\n');
            }
            tc++;
        }
        System.out.println(sb);
    }

    static boolean find(int num) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = (start+end)/2;

            if(num < arr[mid]) end = mid-1;
            else if(num > arr[mid]) start = mid+1;
            else return true;
        }

        return false;
    }
}
