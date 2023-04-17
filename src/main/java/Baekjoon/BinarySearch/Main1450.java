package Baekjoon.BinarySearch;

import java.io.*;
import java.util.*;

// G1 냅색 문제
// Meet in the middle, 중간에서 만나기 알고리즘
// 두개의 그룹으로 나눠, 전체 경우의 수 탐색 (DFS)
// 첫번째 그룹의 무게와 정렬된 두번째 그룹을 이분탐색하며 가능한 인덱스의 끝을 찾아 해당 인덱스만큼 더해준다.
public class Main1450 {

    static int[] objects;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        objects = new int[N];
        for (int i = 0; i < N; i++) {
            objects[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(objects);

        // 0 ~ N / 2 까지의 모든 경우의 수
        List<Integer> leftSums = new ArrayList<>();
        dfs(0, 0, N / 2, leftSums);

        // N / 2 ~ N 까지의 모든 경우의 수
        List<Integer> rightSums = new ArrayList<>();
        dfs(N / 2, 0, N, rightSums);

        // 오름차순 정렬
        Collections.sort(rightSums);

        int answer = 0;

        // 절반의 무게 + 나머지 무게를 이분탐색하여 가능한 만큼 수 더하기
        for (Integer weight : leftSums) {
            answer += search(weight, rightSums);
        }

        System.out.println(answer);
    }

    private static int search(int weight, List<Integer> rightSums) {
        int start = 0;
        int end = rightSums.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (weight + rightSums.get(mid) <= C) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private static void dfs(int index, int sum, int N, List<Integer> sums) {
        if (index == N) {
            sums.add(sum);
            return;
        }

        if (sum + objects[index] <= C) {
            dfs(index + 1, sum + objects[index], N, sums);
        }

        dfs(index + 1, sum, N, sums);
    }
}

