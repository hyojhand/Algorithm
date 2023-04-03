package Baekjoon.DFS;

import java.io.*;
import java.util.*;

// G5 물통
// from -> to 로 물을 옮긴다.
// 1. from을 비운다. from : empty, to : to + from
// 2. to가 꽉 차있다. from : (from - 옮긴 양), to : full
// A 가 0일때, 상태를 저장, 같은 상태의 양은 다시 비교하지 않는다.
// C의 양을 정렬하여 반환
public class Main2251 {
    static Set<Integer> result = new TreeSet<>();
    static boolean[][] visited = new boolean[201][201]; // A와 B 물의 양으로 방문 체크
    static int[] bottle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물통 3개의 용량
        bottle = new int[3];
        for (int i = 0; i < 3; i++) {
            bottle[i] = Integer.parseInt(st.nextToken());
        }

        // dfs 탐색
        dfs(new int[] {0, 0, bottle[2]});

        // 결과 반환
        for (int number : result) {
            System.out.print(number + " ");
        }
    }

    private static void dfs(int[] water) {
        // A와 B의 물양이 방문했다면 return
        if (visited[water[0]][water[1]]) {
            return;
        }

        visited[water[0]][water[1]] = true;

        int A = water[0];
        int B = water[1];
        int C = water[2];

        // A가 비었다면 C 용량 저장
        if (A == 0) {
            result.add(C);
        }

        // A의 물을 B, C로 이동
        if (A != 0) {
            moveWater(0, 1, water);
            moveWater(0, 2, water);
        }

        // B의 물을 A, C로 이동
        if (B != 0) {
            moveWater(1, 0, water);
            moveWater(1, 2, water);
        }

        // C의 물을 A, B로 이동
        if (C != 0) {
            moveWater(2, 0, water);
            moveWater(2, 1, water);
        }

    }

    private static void moveWater(int from, int to, int[] water) {
        int[] copy = water.clone();

        // from 물통을 모두 비울 수 있고, to 물통은 딱 맞거나 부족하다
        if (copy[from] + copy[to] < bottle[to]) {
            copy[to] = copy[to] + copy[from];
            copy[from] = 0;
        }
        // from 물통은 비울 수 없고, to 물통이 꽉 찬다
        else {
            copy[from] = copy[from] - (bottle[to] - copy[to]);
            copy[to] = bottle[to];
        }

        dfs(copy);
    }
}

