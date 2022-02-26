package SWEA.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JungOL1828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[][] refri = new int[N][2];
        refri[0][0] = arr[0][0];
        refri[0][1] = arr[0][1];

        int count = 1;

        for(int i = 1; i < N; i++) {
            boolean isOk = false;

            for(int j = 0; j < count; j++) {
                if(arr[i][0] > refri[j][1]) continue;

                if(arr[i][0] > refri[j][0]) {
                    refri[j][0] = arr[i][0];
                    isOk = true;
                    break;
                }
                else if(arr[i][0] <= refri[j][0]) {
                    isOk = true;
                    break;
                }
            }

            if(!isOk) {
                refri[count][0] = arr[i][0];
                refri[count][1] = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
