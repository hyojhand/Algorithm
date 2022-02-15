package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());

        int[][] arr = new int[tcase][2];
        for (int i = 0; i < tcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]) {
//                    return Integer.compare(o1[1],o2[1]);
//                }
//                else {
//                    return Integer.compare(o1[0],o2[0]);
//                }
//            }
//        });

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < tcase; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
        }

        System.out.println(sb);

    }
}

