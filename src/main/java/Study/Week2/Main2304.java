package Study.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int max = 0;
        int max_index = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if (max < arr[i][1]) {
                max = arr[i][1];
                max_index = arr[i][0];
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] warehouse = new int[arr[N - 1][0] + 1];
        warehouse[arr[0][0]] = arr[0][1];
        int pre = arr[0][1];
        int idx = 1;
        for (int i = arr[0][0] + 1; i <= max_index; i++) {
            if (i == arr[idx][0]) {
                if (pre < arr[idx][1]) {
                    pre = arr[idx][1];
                    warehouse[i] = arr[idx][1];
                } else {
                    warehouse[i] = pre;
                }
                idx++;
            } else {
                warehouse[i] = pre;
            }

        }


        pre = arr[N - 1][1];
        idx = N - 2;
        for (int i = arr[N - 1][0]; i > max_index; i--) {
            if (i == arr[idx][0]) {
                if (pre < arr[idx][1]) {
                    pre = arr[idx][1];
                    warehouse[i] = arr[idx][1];
                } else {
                    warehouse[i] = pre;
                }
                idx--;
            } else {
                warehouse[i] = pre;
            }
        }

        int sum = 0;
        for (int i = 0; i < warehouse.length; i++) {
            sum += warehouse[i];
        }
        System.out.println(sum);
    }
}
