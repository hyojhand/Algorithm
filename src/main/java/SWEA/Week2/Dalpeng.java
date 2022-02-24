package SWEA.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dalpeng {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트케이스 입력
        int testcase = Integer.parseInt(br.readLine());
        int testcount = 1;

        // 테스트케이스만큼 반복실행
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            boolean[][] visit = new boolean[N][N]; // 방문확인 배열

            int number = 1;
            int x = 0;
            int y = 0;

            // 조건에 맞춰 배열에 숫자삽입
            while (N * N >= number) {
                arr[x][y] = number;
                visit[x][y] = true;

                if (y + 1 < N && !visit[x][y + 1]) {
                    y++;
                } else if (x + 1 < N && !visit[x + 1][y]) {
                    x++;
                } else if (y - 1 >= 0 && !visit[x][y - 1]) {
                    y--;
                } else if (x - 1 >= 0 && !visit[x - 1][y]) {
                    x--;
                }

                number++;

            }

            // 테스트케이스 번호 저장
            sb.append("#").append(testcount).append('\n');
            testcount++;
            // StringBuilder에 배열 값 저장
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < arr[0].length; j++) {
                    sb.append(arr[k][j]).append(" ");
                }
                sb.append('\n');
            }

        }

        // 값 출력
        System.out.println(sb);


    }
}
