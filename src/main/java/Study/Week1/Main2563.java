package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int k = a; k < a + 10; k++) {
                for (int l = b; l < b + 10; l++) {
                    paper[k][l] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == 1) sum++;
            }
        }

        System.out.println(sum);

    }
}