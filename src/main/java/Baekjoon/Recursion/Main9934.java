package Baekjoon.Recursion;

import java.io.*;
import java.util.StringTokenizer;
// S1 완전이진트리 - 중위순회 결과로 각 레벨별 번호 반환
public class Main9934 {
    static int[] arr;
    static StringBuilder[] answer;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int size = (int) (Math.pow(2, N) - 1);
        arr = new int[size];
        answer = new StringBuilder[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            answer[i] = new StringBuilder();
        }

        solve(0, arr.length-1, 0);

        for(int i = 0; i < N; i++) {
            System.out.println(answer[i].toString());
        }
    }

    public static void solve(int start,int end, int level) {
        if(level == N) return;

        int mid = (start+end)/2;
        answer[level].append(arr[mid]).append(" ");

        solve(start, mid-1, level+1);
        solve(mid+1, end, level+1);
    }
}
