package Study.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1074 {
    static int count = 0;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        func(N);

    }

    public static void func(int dept) {
        if (dept == 1) {
            if (r == 0) {
                if (c == 0) {
                    System.out.println(count);
                } else {
                    System.out.println(count + 1);
                }
            } else {
                if (c == 0) {
                    System.out.println(count + 2);
                } else {
                    System.out.println(count + 3);
                }
            }
            return;
        }


        if (r < Math.pow(2, dept) / 2) {
            if (c < Math.pow(2, dept) / 2) {
                count += 0;
                func(dept - 1);
            } else {
                count += (int) Math.pow(2, dept + (dept - 2));
                c -= Math.pow(2, dept) / 2;
                func(dept - 1);
            }
        } else {
            if (c < Math.pow(2, dept) / 2) {
                count += (int) Math.pow(2, dept + (dept - 1));
                r -= Math.pow(2, dept) / 2;
                func(dept - 1);
            } else {
                count += ((int) Math.pow(2, dept + (dept - 1)) + Math.pow(2, dept + (dept - 2)));
                r -= Math.pow(2, dept) / 2;
                c -= Math.pow(2, dept) / 2;
                func(dept - 1);
            }
        }

    }

}
