package Study.Week3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pwd = st.nextToken();
            map.put(url, pwd);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            sb.append(map.get(str)).append('\n');
        }

        System.out.println(sb);

    }
}
