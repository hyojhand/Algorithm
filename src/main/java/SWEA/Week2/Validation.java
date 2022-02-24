package SWEA.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class Validation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String func = "+-*/";

        int tc = 0;
        while(tc < 10) {
            int N = Integer.parseInt(br.readLine());
            int result  = 1;

            while(N > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String ch = st.nextToken();

                if(st.hasMoreTokens()) {
                    if(!func.contains(ch)) {
                        result = 0;
                    }
                }
                else {
                    if(func.contains(ch)) {
                        result = 0;
                    }
                }

                N--;
            }

            tc++;
            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }

        System.out.println(sb);
    }
}
