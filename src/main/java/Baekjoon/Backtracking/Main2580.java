package Baekjoon.Backtracking;

import java.io.*;
import java.util.*;
// G4 스도쿠
public class Main2580 {
    static int[][] game = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start_x = 0;
        int start_y = 0;
        addNumber(start_x,start_y);

    }

    static void addNumber(int x,int y) {
        if(y == 9) {
            addNumber(x+1, 0);
            return;
        }

        if(x == 9) getResult();

        if(game[x][y] == 0) {
            for(int k = 1; k <= 9; k++) {
                if(validateRow(x, k) && validateCol(y,k) && validateSquare(x,y,k)) {
                    game[x][y] = k;
                    addNumber(x,y+1);
                }
            }
            game[x][y] = 0;
            return;
        }

        addNumber(x,y+1);
    }

    static void getResult() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(game[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
        System.exit(0);
    }

    static boolean validateRow(int x,int num) {
        for(int i = 0; i < 9; i++) {
            if(game[x][i] == num) return false;
        }
        return true;
    }

    static boolean validateCol(int y,int num) {
        for(int i = 0; i < 9; i++) {
            if(game[i][y] == num) return false;
        }
        return true;
    }

    static boolean validateSquare(int x,int y,int num) {
        int square_start_x = (x / 3) * 3;
        int square_start_y = (y / 3) * 3;

        for(int i = square_start_x; i < square_start_x+3; i++) {
            for(int j = square_start_y; j < square_start_y+3; j++) {
                if(game[i][j] == num) return false;
            }
        }
        return true;
    }

}

