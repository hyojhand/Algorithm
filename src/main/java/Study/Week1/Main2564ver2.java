package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2564ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());
        int[] num = new int[count + 1];
        for (int i = 0; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            switch (dir) {
                case 1:
                    num[i] = N - Integer.parseInt(st.nextToken());
                    break;
                case 2:
                    num[i] = N + M + Integer.parseInt(st.nextToken());
                    break;
                case 3:
                    num[i] = N + Integer.parseInt(st.nextToken());
                    break;
                case 4:
                    num[i] = (N + M) * 2 - Integer.parseInt(st.nextToken());
                    break;
            }
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            int temp = Math.abs(num[count] - num[i]);
            int min = Math.min(temp, (N + M) * 2 - temp);
            sum += min;
        }
        System.out.println(sum);

    }
}
