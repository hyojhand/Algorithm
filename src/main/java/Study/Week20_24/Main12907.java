package Study.Week20_24;

import java.io.*;
import java.util.*;
// 동물원
public class Main12907 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[41];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
        }

        boolean isDouble = false;
        int result = 1;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(arr[i] == 2) {
                if(i == 0) result = 2;
                else {
                    if (arr[i - 1] == 2) result *= 2;
                    else break;
                }
            } else if(arr[i] == 1) {
                isDouble = true;
            } else break;

            sum += arr[i];
        }

        if(isDouble) result *= 2;
        if(sum != N) System.out.println(0);
        else System.out.println(result);

    }
}

