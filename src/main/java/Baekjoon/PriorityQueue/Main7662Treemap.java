package Baekjoon.PriorityQueue;

import java.io.*;
import java.util.*;

public class Main7662Treemap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String func = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (func.equals("I")) map.put(num, map.getOrDefault(num, 0) + 1);
                else {
                    if(map.size() == 0) continue;

                    int a = num == 1 ? map.lastKey() : map.firstKey();

                    if(map.get(a) == 1) map.remove(a);
                    else map.put(a, map.get(a) - 1);
                }
            }

            sb.append(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey()).append('\n');
        }
        System.out.println(sb);
    }
}
