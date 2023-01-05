package Baekjoon.DFS;

import java.io.*;
import java.util.*;
// G5 숫자고르기 - 순환이 있는 수를 고르는 것이 핵심, 한 선택지를 따라가서 끝에 처음 선택한 수가 나와 사이클이 생성되면 리스트에 넣는다
public class Main2668 {
    static int[] numbers;
    static boolean[] check;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            check[i] = true;
            dfs(i, i);
            check[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(int number, int target) {
        if (numbers[number] == target) {
            list.add(target);
        }

        if (!check[numbers[number]]) {
            check[number] = true;
            dfs(numbers[number], target);
            check[number] = false;
        }
    }
}

