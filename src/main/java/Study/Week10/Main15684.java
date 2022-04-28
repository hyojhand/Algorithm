package Study.Week10;

import java.io.*;
import java.util.StringTokenizer;
// 사다리 조작
public class Main15684 {
    static int N,H;
    static int[][] check;
    static int min = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        check = new int[H+1][N+1];
        int num = 1;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = num;
            check[a][b+1] = num;
            num++;
        }

        game(0);
        find(1,0,num+1);
        if(min == 4) min = -1;
        System.out.println(min);
    }

    static void find(int x,int bridge,int num) {
        if(bridge == 3) {
            game(bridge);
            return;
        }

        game(bridge);
        for(int i = x; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(check[i][j]==0 && j+1<=N &&check[i][j+1]==0
                        && bridge + 1 < min && bridge < 3) {
                    check[i][j] = num;
                    check[i][j+1] = num;
                    find(i,bridge + 1,num+1);
                    check[i][j] = 0;
                    check[i][j+1] = 0;
                }
            }
        }
    }

    static void game(int bridge) {
        int line;
        for(int i = 1; i <= N; i++) {
            line = i;
            int level = 1;
            while(level <= H) {
                if(check[level][line] > 0) {
                    if(line-1>= 1 && check[level][line-1]==check[level][line]) line--;
                    else if(line+1<=N && check[level][line+1]==check[level][line]) line++;
                }
                level++;
            }

            if(i != line) return;
        }

        min = Math.min(min,bridge);
    }
}

