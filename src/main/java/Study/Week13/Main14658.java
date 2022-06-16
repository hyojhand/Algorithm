package Study.Week13;

import java.io.*;
import java.util.StringTokenizer;
// 하늘에서 별똥별이 빗발친다
public class Main14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] star = new int[K][2];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            star[i][0] = a;
            star[i][1] = b;
        }

        int max = 0;

        for(int k = 0; k < K; k++) {
            int x = star[k][0];
            int y = star[k][1];

            for(int i = x-L; i <= x; i++) {
                if(i < 0) continue;
                int count = 0;
                for(int l = 0; l < K; l++) {
                    int tx = star[l][0];
                    int ty = star[l][1];
                    if(i <= tx && tx <= i+L && y <= ty && ty <= y+L) count++;
                }
                max = Math.max(max,count);
            }
        }

        System.out.println(K-max);
    }
}
