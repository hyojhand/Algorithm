package Programmers.Kakao.Kakao2022;

// 누적합 풀이
// (r1,c1), (r2 + 1,c2 + 1) 지점은 degree로, 각 시작 행과 열의 끝은 -degree로 갱신
// 누적합 계산 이후 최초 값과 누적합 배열 더하기
public class DestroyBuilding {
    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;

        int[][] sum = new int[row + 1][col + 1];

        for (int[] info : skill) {
            int type = info[0];
            int r1 = info[1];
            int c1 = info[2];
            int r2 = info[3];
            int c2 = info[4];
            int degree = (type == 1) ? -info[5] : info[5];

            sum[r1][c1] += degree;
            sum[r2 + 1][c2 + 1] += degree;

            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
        }

        // 위에서 아래로 누적합 실행
        for (int i = 0; i < col + 1; i++) {
            for (int j = 1; j < row + 1; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }

        // 좌에서 우로 누적합 실행
        for (int i = 0; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        int answer = 0;
        // 누적합과 현재 배열을 더해 내구도가 남은 개수 구하기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
