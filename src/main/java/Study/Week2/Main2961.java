package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main2961 {
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        find(0, N, 1, 0);
        System.out.println(min);

    }

    public static void find(int dept, int N, int sour, int bitt) {
        if (dept == N) {
            if (bitt == 0) return;
            min = Math.min(min, Math.abs(sour - bitt));
            return;
        }

        find(dept + 1, N, sour * arr[dept][0], bitt + arr[dept][1]);
        find(dept + 1, N, sour, bitt);
    }
}
