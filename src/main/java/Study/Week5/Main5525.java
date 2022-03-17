package Study.Week5;

import java.io.*;

public class Main5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String str = "I";
        for (int i = 0; i < N; i++) {
            str += "OI";
        }

        int count = 0;
        for (int i = 0; i < M - (2 * N + 1); i++) {
            if (S.charAt(i) == 'I') {
                if (S.substring(i, i + (2 * N + 1)).equals(str)) count++;
            }
        }

        System.out.println(count);
    }
}
