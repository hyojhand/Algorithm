package Study.Week2;

import java.io.*;

public class Main1992 {
    static int[][] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        if(N == 1) {
            sb.append(arr[0][0]);
        }
        else {
            find(N, 0, 0);
        }

        System.out.println(sb);

    }

    public static void find(int N, int x, int y) {
        int num = arr[x][y];
        boolean NotFind = false;
        Loop1:
        for (int i = x; i < x+N; i++) {
            for (int j = y; j < y+N; j++) {
                if (arr[i][j] != num) {
                    NotFind = true;
                    break Loop1;
                }
            }
        }
        if (NotFind) {
            sb.append("(");
            find(N / 2, x, y);
            find(N / 2, x, y + N / 2);
            find(N / 2, x + N / 2, y);
            find(N / 2, x + N / 2, y + N / 2);
            sb.append(")");
        } else {
            sb.append(num);
        }

    }
}
