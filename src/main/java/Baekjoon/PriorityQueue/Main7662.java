package Baekjoon.PriorityQueue;

import java.io.*;
import java.util.*;
//G4 이중우선순위큐
public class Main7662 {
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String func = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (func.equals("I")) {
                    min.offer(num);
                    max.offer(num);

                    map.put(num, map.getOrDefault(num, 0)+ 1);
                } else {
                    if (map.size() == 0) continue;

                    if (num == -1) delete(min);
                    else delete(max);
                }
            }


            if (map.size() == 0) sb.append("EMPTY").append('\n');
            else {
                int a = delete(max);
                sb.append(a).append(" ").append(map.size() > 0 ? delete(min) : a).append('\n');
            }

            T--;
        }

        System.out.println(sb);
    }

    public static int delete(PriorityQueue<Integer> que) {
        int num;
        while(true) {
            if(que.isEmpty()) continue;

            num = que.poll();
            int cnt = map.getOrDefault(num, 0);

            if(cnt == 0) continue;

            if(cnt == 1) map.remove(num);
            else map.put(num, cnt-1);

            break;
        }
        return num;
    }

}
