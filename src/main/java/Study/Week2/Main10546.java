package Study.Week2;

import java.io.*;
import java.util.HashMap;

public class Main10546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N * 2 - 1; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.replace(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        for (String n : map.keySet()) {
            if (map.get(n) % 2 != 0) {
                System.out.println(n);
                break;
            }
        }

    }
}
