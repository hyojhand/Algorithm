package Study.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[1001][1001];

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            for (int k = x; k < x + nx; k++) {
                for (int l = y; l < y + ny; l++) {
                    arr[k][l] = i + 1;
                }
            }

        }

        for (int n = 0; n < N; n++) {
            int count = 0;
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (arr[i][j] == n + 1) {
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);


    }
}
