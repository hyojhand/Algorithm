package Study.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main15666 {
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[M];

        HashSet<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        arr = new Integer[hs.size()];
        hs.toArray(arr);
        Arrays.sort(arr);

        func(M, 0);

        System.out.println(sb);

    }

    public static void func(int M, int dept) {
        if (dept == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            result[dept] = arr[i];
            if (dept != 0) {
                if (result[dept] < result[dept - 1]) {
                    continue;
                }
            }
            func(M, dept + 1);
        }
    }

}
