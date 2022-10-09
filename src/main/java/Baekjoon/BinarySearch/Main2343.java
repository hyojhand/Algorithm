package Baekjoon.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

// 기타레슨 S1
public class Main2343 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int start = -1;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        int result = find(start, end, M);
        System.out.println(result);
    }

    static int find(int start, int end, int M) {
        while(start <= end) {
            int mid = (start+end)/2;

            int size = getSize(mid);
            if(size > M) start = mid + 1;
            else end = mid-1;
        }
        return start;
    }

    static int getSize(int num) {
        int sum = arr[0];
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(sum + arr[i] > num) {
                count++;
                sum = arr[i];
            } else sum += arr[i];
        }

        if(sum != 0) count++;
        return count;
    }
}
