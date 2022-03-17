package Study.Week5;

import java.io.*;
import java.util.StringTokenizer;

public class Main2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        String result = "";

        for(int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = arr[1] - arr[0];
        boolean isAsc = false;
        if(num > 0) isAsc = true;

        for(int i = 2; i < 8; i++) {
            num = arr[i] - arr[i-1];
            if(isAsc) {
                if(num < 0) {
                    result = "mixed";
                    break;
                }
            }
            else {
                if(num > 0) {
                    result = "mixed";
                    break;
                }
            }
        }

        if(result.equals("")) {
            if(isAsc) result = "ascending";
            else result = "descending";
        }

        System.out.println(result);
    }
}
