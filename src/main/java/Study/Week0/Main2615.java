package Study.Week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2615 {
    static int[][] omok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        omok = new int[19][19];

        int winner = 0; // 0 승부x, 1 검은돌, 2 흰돌
        int win_row = 0; // 이긴 행 위치
        int win_col = 0; // 이긴 열 위치


        // 오목배열에 값 넣기
        for (int i = 0; i < omok.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < omok[0].length; j++) {
                omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오목판 탐색
        for (int j = 0; j < omok[0].length; j++) {
            for (int i = 0; i < omok.length; i++) {

                int right_num = right(i, j + 1, omok[i][j], 1);
                int downright_num = downright(i + 1, j + 1, omok[i][j], 1);
                int down_num = down(i + 1, j, omok[i][j], 1);
                int upright_num = upright(i - 1, j + 1, omok[i][j], 1);

                // 검은 돌이라면
                if (omok[i][j] == 1) {
                    if(right_num == 5) {
                        if(j == 0 || omok[i][j-1] != 1) {
                            winner = 1;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(downright_num == 5) {
                        if(j == 0 || i == 0 || omok[i-1][j-1] != 1) {
                            winner = 1;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(down_num == 5) {
                        if(i == 0 || omok[i-1][j] != 1) {
                            winner = 1;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(upright_num == 5) {
                        if(i == 18 || j == 0 || omok[i+1][j-1] != 1) {
                            winner = 1;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                }       // 흰색 돌이라면
                else if (omok[i][j] == 2) {
                    if(right_num == 5) {
                        if(j == 0 || omok[i][j-1] != 2) {
                            winner = 2;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(downright_num == 5) {
                        if(j == 0 || i == 0 || omok[i-1][j-1] != 2) {
                            winner = 2;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(down_num == 5) {
                        if(i == 0 || omok[i-1][j] != 2) {
                            winner = 2;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                    else if(upright_num == 5) {
                        if(i == 18 || j == 0 || omok[i+1][j-1] != 2) {
                            winner = 2;
                            win_row = i + 1;
                            win_col = j + 1;
                            break;
                        }
                    }
                }

            }

            if (winner == 1 || winner == 2) break;

        }

        if (winner == 0) {
            System.out.println(winner);
        } else {
            System.out.println(winner);
            System.out.println(win_row + " " + win_col);
        }

    }


    public static int right(int x, int y, int stone, int count) {
        if (y > 18) {
            return count;
        }

        if (omok[x][y] == stone) {
            count = right(x, y + 1, stone, count + 1);
        }

        return count;
    }


    public static int downright(int x, int y, int stone, int count) {
        if (x > 18 || y > 18) {
            return count;
        }

        if (omok[x][y] == stone) {
            count = downright(x + 1, y + 1, stone, count + 1);
        }
        return count;
    }

    public static int down(int x, int y, int stone, int count) {
        if (x > 18) {
            return count;
        }

        if (omok[x][y] == stone) {
            count = down(x + 1, y, stone, count + 1);
        }

        return count;
    }

    public static int upright(int x, int y, int stone, int count) {
        if (x < 0 || y > 18) {
            return count;
        }

        if (omok[x][y] == stone) {
            count = upright(x - 1, y + 1, stone, count + 1);
        }

        return count;
    }

}
