package Study.Week8;

import java.io.*;
import java.util.*;
// 내일 할거야
public class Main7983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int time = arr[0][1];
        for(int i = 0; i < N-1; i++) {
            int num = time - arr[i][0];
            if(num > arr[i+1][1]) time = arr[i+1][1];
            else time = num;
        }

        time -= arr[N-1][0];
        System.out.println(time);

    }
}

