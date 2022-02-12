package SWEA.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Farm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int tcount = 0;

        while(tcount < T) {
            int N = Integer.parseInt(br.readLine());

            // farm배열에 수익 저장
            char[][] farm = new char[N][N];
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j);
                }
            }

            // 수익 더하기
            int index = N/2;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(i <= N/2) {
                    for(int j = index; j < (index+(2*i + 1)); j++) {
                        sum += farm[i][j]-'0';
                    }
                    index--;
                }
                else {
                    // index를 다시 늘려주기위해 1부터 시작
                    if(index == -1) {
                        index = 1;
                    }

                    for(int j = index; j < (index+(N - 2*index)); j++) {
                        sum += farm[i][j]-'0';
                    }
                    index++;
                }

            }

            tcount++;
            sb.append("#").append(tcount).append(" ");
            sb.append(sum).append('\n');
        }

        System.out.println(sb);

    }
}
