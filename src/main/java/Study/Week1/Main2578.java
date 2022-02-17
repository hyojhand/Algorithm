package Study.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Main2578 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer_count = 0;

        Bingo :
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                answer_count++;

                for(int k = 0; k < 5; k++) {
                    for(int l = 0; l < 5; l++) {
                        if(arr[k][l] == num) {
                            arr[k][l] = 0;
                            if(bingo()) {
                                break Bingo;
                            }
                        }

                    }
                }

            }
        }

        System.out.println(answer_count);

    }

    public static boolean bingo() {
        int bingo_count = 0;

        for(int i = 0; i < 5; i++) {
            int row_count = 0;
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] == 0) row_count++;
            }
            if(row_count == 5) bingo_count++;

            if(bingo_count == 3) return true;
        }

        for(int j = 0; j < 5; j++) {
            int col_count = 0;
            for(int i = 0; i < 5; i++) {
                if(arr[i][j] == 0) col_count++;
            }
            if(col_count == 5) bingo_count++;

            if(bingo_count == 3) return true;
        }


        int cross_count = 0;
        for(int i = 0; i < 5; i++) {
            if(arr[i][i] == 0) cross_count++;
            if(cross_count == 5) bingo_count++;

            if(bingo_count == 3) return true;
        }


        int x = 4;
        cross_count = 0;
        for(int i = 0; i < 5; i++) {
            if(arr[i][x] == 0) cross_count++;
            x--;
            if(cross_count == 5) bingo_count++;

            if(bingo_count == 3) return true;
        }

        return false;
    }

}
