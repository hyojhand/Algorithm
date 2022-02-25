package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[100][100];

        for (int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = 1;
                }
            }
        }

        int[] delta_x = {0, 1, -1, 0};
        int[] delta_y = {1, 0, 0, -1};

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + delta_x[k];
                        int ny = j + delta_y[k];

                        if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || paper[nx][ny] == 0) {
                            count++;
                        }

                    }
                }

            }
        }

        System.out.println(count);

    }
}
