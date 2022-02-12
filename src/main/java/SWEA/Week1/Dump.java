package SWEA.Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dump {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] dump_arr = new int[100];

        int testcase = 0;
        while (testcase < 10) {
            int dump_max = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                dump_arr[i] = Integer.parseInt(st.nextToken());
            }

            while (dump_max > 0) {
                Arrays.sort(dump_arr);
                dump_arr[99]--;
                dump_arr[0]++;

                if (dump_arr[0] == dump_arr[99]) {
                    break;
                } else {
                    dump_max--;
                }
            }

            Arrays.sort(dump_arr);

            int result = dump_arr[99] - dump_arr[0];

            testcase++;
            sb.append("#").append(testcase).append(" ");
            sb.append(result).append('\n');
        }

        System.out.println(sb);

    }
}
