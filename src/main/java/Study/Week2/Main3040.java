package Study.Week2;

import java.io.*;

public class Main3040 {
    static int[] arr = new int[9];
    static int[] result = new int[7];
    static boolean[] check = new boolean[9];
    static boolean isFind = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        find(0);
        System.out.println(sb);

    }

    public static void find(int dept) {
        int sum = 0;
        if(dept == 7) {
            for(int n: result) {
                sum += n;
            }
            if(sum == 100) {
                for(int n: result) {
                    sb.append(n).append('\n');
                }
                isFind = true;
            }
            return;
        }


        for(int i = 0; i < 9; i++) {
            if(!check[i]) {
                check[i] = true;
                result[dept] = arr[i];
                find(dept+1);

                if(isFind) return;
                check[i] = false;
            }
        }

    }
}
