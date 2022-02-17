package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int k = x1; k < x2; k++) {
                for(int l = y1; l <y2; l++) {
                    arr[k][l] = 1;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(arr[i][j] == 1) sum++;
            }
        }
        System.out.println(sum);

    }
}
