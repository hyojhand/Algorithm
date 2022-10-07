package Baekjoon.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 숫자카드2 S4
public class Main10816 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int count = upper(num) - lower(num);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }


    static int lower(int num) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = (start+end)/2;

            if(num <= arr[mid]) end = mid;
            else start = mid+1;
        }

        return start;
    }

    static int upper(int num) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = (start+end)/2;

            if(num < arr[mid]) end = mid;
            else start = mid+1;
        }
        return start;
    }
}
