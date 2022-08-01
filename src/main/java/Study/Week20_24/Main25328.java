package Study.Week20_24;

import java.io.*;
import java.util.*;
// 문자열 집합 조합하기
public class Main25328 {
    static int K;
    static HashSet<String> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();
        K = Integer.parseInt(br.readLine());

        find(X, "", 0, 0);
        find(Y, "", 0, 0);
        find(Z, "", 0, 0);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        if(list.size() == 0) System.out.println(-1);
    }

    static void find(String str,String result, int idx, int dept) {
        if(dept == K) {
            if(map.get(result) != null) {
                map.put(result, map.get(result)+1);
            } else {
                map.put(result, 1);
            }

            if(map.get(result) >= 2) set.add(result);
            return;
        }

        for(int i = idx; i < str.length(); i++) {
            char c = str.charAt(i);
            String temp = result;
            temp += c;
            find(str, temp, i+1, dept+1);
        }

    }
}