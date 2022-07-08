package Study.Week19;

import java.io.*;
import java.util.StringTokenizer;

// 색종이 만들기
public class Main2630 {
    static int[][] arr;
    static int white,blue = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        temp(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void temp(int x,int y,int n) {
        if(n == 1) {
            if(arr[x][y] == 1) blue++;
            else white++;
            return;
        }

        if(check(x,y,n)) {
            if(arr[x][y] == 1) blue++;
            else white++;
        } else {
            seperate(x,y,n/2);
        }
    }

    static void seperate(int x,int y, int n) {
        for(int i = x; i <= x+ n; i+=n) {
            for(int j = y; j <= y + n; j+= n) {
                temp(i,j,n);
            }
        }
    }

    static boolean check(int x,int y, int n) {
        int color = arr[x][y];
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                if(arr[i][j] != color) return false;
            }
        }
        return true;
    }
}

