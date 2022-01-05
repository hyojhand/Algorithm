package Baekjoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = arr.clone();
        Arrays.sort(arr);

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hmap.containsKey(arr[i])) {
                hmap.put(arr[i], cnt++);
            }
        }

        for (int i = 0; i < num; i++) {
            sb.append(hmap.get(temp[i])).append(" ");
        }
        System.out.println(sb);

    }
}
