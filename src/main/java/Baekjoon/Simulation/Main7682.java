package Baekjoon.Simulation;

import java.io.*;

// G5 틱택토
public class Main7682 {
    static boolean oWin, xWin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            oWin = false;
            xWin = false;

            if (validateGame(input)) builder.append("valid");
            else builder.append("invalid");
            builder.append('\n');
        }

        System.out.println(builder);
    }

    private static boolean validateGame(String input) {
        char[][] board = new char[3][3];

        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt((i * 3) + j);

                if (board[i][j] == 'O') oCount++;
                if (board[i][j] == 'X') xCount++;
            }
        }

        // 둘의 차이가 2 이상이거나, 후공의 개수가 더 많으면 false
        if (Math.abs(oCount - xCount) >= 2 || xCount < oCount) {
            return false;
        }

        // 행, 열, 대각선 체크
        rowCheck(board);
        colCheck(board);
        crossCheck(board);

        // 둘다 이기는 경우는 잘못된 게임
        if (oWin && xWin) {
            return false;
        }

        // 선공이 이겼는데, 선공의 개수가 1개 많은게 아니라면 잘못된 게임
        if (xWin && (xCount - oCount) != 1) {
            return false;
        }

        // 후공이 이겼는데, 선공과 개수가 같지 않다면 잘못된 게임
        if (oWin && oCount != xCount) {
            return false;
        }

        // 승리하지 않았는데 개수가 9로 모두 차지 않았다면 잘못된 게임
        if (!oWin && !xWin && oCount + xCount != 9) {
            return false;
        }

        return true;
    }

    private static void crossCheck(char[][] board) {
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            oWin = true;
        }
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            xWin = true;
        }

        // 우상 대각선
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            oWin = true;
        }
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            xWin = true;
        }
    }

    private static void colCheck(char[][] board) {
        for (int i = 0; i < 3; i++) {
            int oCount = 0;
            int xCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'O') oCount++;
                if (board[j][i] == 'X') xCount++;
            }

            if (oCount == 3) oWin = true;
            if (xCount == 3) xWin = true;
        }
    }

    private static void rowCheck(char[][] board) {
        for (int i = 0; i < 3; i++) {
            int oCount = 0;
            int xCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'O') oCount++;
                if (board[i][j] == 'X') xCount++;
            }

            if (oCount == 3) oWin = true;
            if (xCount == 3) xWin = true;
        }
    }
}

