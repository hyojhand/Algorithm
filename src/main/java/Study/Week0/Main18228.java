package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] ice = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < count; i++) {
            ice[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < count; i++) {
            if(ice[i] == -1) {
                sum += min;
                min = Integer.MAX_VALUE;
                continue;
            }
            min = Math.min(ice[i] , min);
        }
        sum += min;
        System.out.println(sum);

    }
}
