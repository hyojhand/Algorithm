package Baekjoon.Greedy;

import java.io.*;
import java.util.*;
// G5 행복유치원 - K개의 연속된 수들의 그룹으로 나누되, 각 그룹의 최대-최소의 총합이 최소가 되게하라
// 인접한 수들끼리의 차이를 list에 넣고 정렬, 전체에서 그룹으로 정해야될 수만큼 빼고 나머지만큼은 합치는 것이니 차이를 더해주면 최소값이 된다.
public class Main13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> diff_list = new ArrayList<>();
        int pre = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            diff_list.add(next-pre);
            pre = next;
        }

        Collections.sort(diff_list);

        int answer = 0;
        for(int i = 0; i < N-K; i++) {
            answer += diff_list.get(i);
        }
        System.out.println(answer);
    }
}

