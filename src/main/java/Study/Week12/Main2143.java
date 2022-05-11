package Study.Week12;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 두 배열의 합
public class Main2143 {
    static int T,N,M;
    static int[] A,B,Aarr,Barr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        Aarr = new int[(1+N)*N/2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = i; j <= N; j++) {
                sum += A[j];
                Aarr[idx++] = sum;
            }
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M+1];
        Barr = new int[(1+M)*M/2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        idx = 0;
        for(int i = 1; i <= M; i++) {
            int sum = 0;
            for(int j = i; j <= M; j++) {
                sum += B[j];
                Barr[idx++] = sum;
            }
        }

        Arrays.sort(Aarr);
        Arrays.sort(Barr);

        int Aidx = 0;
        int Bidx = (1+M)*M/2-1;

        long count = 0;
        while(Aidx <= (1+N)*N/2-1 && Bidx >= 0) {

            int sum = Aarr[Aidx] + Barr[Bidx];
            if(sum == T) {
                long Acount = 0;
                long Bcount = 0;
                int anum = Aarr[Aidx];
                int bnum = Barr[Bidx];
                while(Aidx<=(1+N)*N/2-1 && Aarr[Aidx] == anum) {
                    Acount++;
                    Aidx++;
                }

                while(Bidx>=0 && Barr[Bidx] == bnum) {
                    Bcount++;
                    Bidx--;
                }

                count += Acount*Bcount;
            }
            else if(sum < T) Aidx++;
            else Bidx--;
        }

        System.out.println(count);
    }
}

