package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int N = 0;
        int M = 0;
        Loop: for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    N = i;
                    M = j;
                    break Loop;
                }
            }
        }

        char[][] arr = new char[B.length()][A.length()];
        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                if (i == M) {
                    arr[i][j] = A.charAt(j);
                } else if (j == N) {
                    arr[i][j] = B.charAt(i);
                } else {
                    arr[i][j] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);


    }
}
