package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main30299 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean isOk = true;
            int sum = 0;
            String str = "";
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                String score = st.nextToken();
                if (Integer.parseInt(score) < L) {
                    isOk = false;
                    break;
                }
                sum += Integer.parseInt(score);
                str = str + score + " ";
            }

            if(sum >= K && isOk) {
                sb.append(str);
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb);


    }
}
