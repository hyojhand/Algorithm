package SWEA.Week3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CardGame {
    static boolean[] check = new boolean[9];
    static int[] result = new int[9];
    static int[] inyoung = new int[9];
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int win_Kyu;
    static int win_Iny;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tc = 0;

        while(tc < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win_Kyu = 0;
            win_Iny = 0;

            for(int i = 0; i < 9; i++) {
                map.put(i, Integer.parseInt(st.nextToken()));
            }

            int idx = 0;
            for(int i = 1; i <= 18; i++) {
                if(!map.containsValue(i)) {
                    inyoung[idx] = i;
                    idx++;
                }
            }

            find(0);

            tc++;
            sb.append("#").append(tc).append(" ");
            sb.append(win_Kyu).append(" ").append(win_Iny).append('\n');
        }

        System.out.println(sb);

    }

    public static void find(int dept) {
        if(dept == 9) {
            int sum_Kyu = 0;
            int sum_Iny = 0;
            for(int i = 0; i < 9; i++) {
                if(map.get(i) > result[i]) sum_Kyu += (map.get(i)+result[i]);
                else sum_Iny += (map.get(i)+result[i]);
            }
            if(sum_Kyu > sum_Iny) win_Kyu++;
            else if(sum_Iny > sum_Kyu) win_Iny++;
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!check[i]) {
                check[i] = true;
                result[dept] = inyoung[i];
                find(dept+1);
                check[i] = false;
            }
        }


    }
}
