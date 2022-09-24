package Study.Week25_29;

import java.io.*;
import java.util.*;
// 기타줄
public class Main1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pack = new int[M];
        int[] one = new int[M];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack);
        Arrays.sort(one);

        int result = Math.min(((N/6)+1) * pack[0], N * one[0]);
        result = Math.min(result, (N/6)*pack[0] + (N%6)*one[0]);
        System.out.println(result);
    }
}
