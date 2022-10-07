package Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수찾기 S4
public class Main1920 {
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
            boolean flag = find(num);
            if(flag) sb.append(1);
            else sb.append(0);

            sb.append('\n');
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
