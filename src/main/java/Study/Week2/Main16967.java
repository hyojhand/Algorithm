package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < H + X; i++) {
            for (int j = 0; j < W + Y; j++) {
                if (X <= i && Y <= j && i < H && j < W) {
                    result[i][j] = arr[i][j] - result[i - X][j - Y];
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
}
