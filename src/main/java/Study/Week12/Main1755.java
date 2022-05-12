package Study.Week12;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 숫자놀이
public class Main1755 {
    static int[] num = {10,5,9,8,3,2,7,6,1,4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[M-N+1];
        int idx = 0;
        for(int i = N; i <= M; i++) {
            arr[idx] = i;
            idx++;
        }

        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1/10 == 0) {
                    if(o2/10 == 0) return num[o1%10]-num[o2%10];
                    else return num[o1%10]-num[o2/10];
                }

                if(o2/10 == 0) return num[o1/10]-num[o2%10];

                if(num[o1/10] == num[o2/10]) return num[o1%10]-num[o2%10];
                else return num[o1/10]- num[o2/10];
            }
        });

        for(int i = 0; i < M-N+1; i++) {
            sb.append(arr[i]).append(" ");
            if(i%10 == 9) sb.append('\n');
        }
        System.out.println(sb);
    }

}