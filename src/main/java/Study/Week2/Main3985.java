package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());


        int[] expect = new int[N + 1];
        int expect_max = 0;
        int expect_num = 0;

        int[] cake = new int[L + 1];
        int cake_max = 0;
        int cake_num = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            expect[i] = b - a + 1;
            if (expect_max < expect[i]) {
                expect_max = expect[i];
                expect_num = i;
            }

            int count = 0;
            for (int k = a; k <= b; k++) {
                if (cake[k] != -1) {
                    cake[k] = -1;
                    count++;
                }
            }
            if (cake_max < count) {
                cake_max = count;
                cake_num = i;
            }

        }

        System.out.println(expect_num);
        System.out.println(cake_num);


    }
}
