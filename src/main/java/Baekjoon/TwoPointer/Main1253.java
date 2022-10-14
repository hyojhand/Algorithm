package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;
// 좋다 G4 / 투 포인터
public class Main1253 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(find(i)) result++;
        }

        System.out.println(result);
    }

    static boolean find(int idx) {
        int start = 0;
        int end = n - 1;
        int num = arr[idx];

        while(true) {
            if(start == idx) start++;
            else if(end == idx) end--;

            if(end <= start) break;

            int sum = arr[start] + arr[end];

            if(sum < num) start++;
            else if(sum > num) end--;
            else return true;
        }
        return false;
    }

}
