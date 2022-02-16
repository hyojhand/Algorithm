package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        boolean isInc = false;
        boolean isDec = false;
        int count = 0;
        if (N == 1) {
            count = 1;
        } else {
            for (int i = 0; i < N - 1; i++) {
                count++;

                if (isInc) {
                    if (arr[i] <= arr[i + 1]) {
                        if (i == N - 2) count++;
                        continue;
                    } else {
                        isInc = false;
                        max = Math.max(max, count);
                        count = 1;
                        for (int j = i - 1; j >= 0; j--) {
                            if (arr[i] == arr[j]) count++;
                            else break;
                        }
                    }
                }

                if (isDec) {
                    if (arr[i] >= arr[i + 1]) {
                        if (i == N - 2) count++;
                        continue;
                    } else {
                        isDec = false;
                        max = Math.max(max, count);
                        count = 1;
                        for (int j = i - 1; j >= 0; j--) {
                            if (arr[i] == arr[j]) count++;
                            else break;
                        }
                    }
                }

                if (i == N - 2) {
                    if (arr[i] == arr[i + 1]) count++;
                    break;
                }

                if (arr[i] < arr[i + 1]) isInc = true;
                if (arr[i] > arr[i + 1]) isDec = true;
            }
        }

        max = Math.max(max, count);

        System.out.println(max);

    }
}
