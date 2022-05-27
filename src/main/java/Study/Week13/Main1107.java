package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 리모컨
public class Main1107 {
    static boolean[] broke = new boolean[10];
    static int N,min,length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                broke[Integer.parseInt(st.nextToken())] = true;
            }
        }

        length = Integer.toString(N).length();
        min = Math.abs(N-100);
        find(0,"");

        System.out.println(min);
    }

    static String find(int dept, String ch) {
        if(dept <= length) {
            for (int i = 0; i < 10; i++) {
                if (!broke[i]) {
                    String str = find(dept+1, ch+i);
                    int num = Integer.parseInt(str);
                    min = Math.min(min,Math.abs(num-N) + dept+1);
                }
            }
        }
        return ch;
    }
}

