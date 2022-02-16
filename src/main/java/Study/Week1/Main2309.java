package Study.Week1;

import java.io.*;
import java.util.Arrays;

public class Main2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int[] arr = new int[9];
        int[] result = new int[7];
        for(int i = 0; i < 9; i++) {
            arr[i] += Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int x = sum - 100;
        int a = 0;
        int b = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(arr[i] + arr[j] == x) {
                    a = arr[i];
                    b = arr[j];
                    break;
                }
            }
        }

        int index = 0;
        for(int i = 0; i < 9; i++) {
            if(arr[i] == a || arr[i] == b) {
                continue;
            }
            result[index] = arr[i];
            index++;
        }

        Arrays.sort(result);

        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }
}
