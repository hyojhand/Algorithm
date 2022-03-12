package Study.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
    static char[] arr;
    static int L, C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        find(0, 0, "");

        System.out.println(sb);


    }

    public static void find(int dept, int x, String str) {
        if (dept == L) {

            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
            if (count >= 1 && (str.length() - count) >= 2) {
                sb.append(str).append('\n');
            }
            return;
        }

        for (int i = x; i < C; i++) {
            find(dept + 1, i + 1, str + arr[i]);
        }

    }
}
