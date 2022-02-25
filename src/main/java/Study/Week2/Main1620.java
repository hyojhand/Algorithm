package Study.Week2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pokemon_num = new HashMap<>();
        HashMap<String, Integer> pokemon_name = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            pokemon_num.put(i + 1, str);
            pokemon_name.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.charAt(0) - '0' <= 9) {
                sb.append(pokemon_num.get(Integer.parseInt(str)));
            } else {
                sb.append(pokemon_name.get(str));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
