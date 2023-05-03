package Programmers.Kakao.Kakao2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 프렌즈4블록
// 각 값을 확인하며 빈공간이 아니라면, 인접한 3방향(우,하,우하)가 범위를 넘어가지 않으며 값이 같다면,
// 터트릴 수 있는 블럭들로 생각하고 4곳을 true로 표시하는 boolean 배열 반환
// true로 표시된 곳을 터트리며 '0'으로 바꾸고 터트린 개수를 가져온다.
// 빈 공간을 압축하기 위해, 각 열별로 빈 공간이 아닌 값을 Stack에 넣고, 가장 아래 행부터 차례로 채워간다.
// 터트린 개수가 0이라면 더이상 인접한 블록이 없으므로 함수를 끝내고, 아니라면 위의 과정을 반복한다.
class Friends4Block {

    int[] dx = {1, 0, 1};
    int[] dy = {0, 1, 1};
    char[][] game;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        game = new char[m][n];
        for (int i = 0; i < m; i++) {
            String value = board[i];
            for (int j = 0; j < n; j++) {
                game[i][j] = value.charAt(j);
            }
        }

        while (true) {
            // 터트릴 수 있는 배열 위치 확인
            boolean[][] checkBoom = getCanBoomCheck();

            // 터트리기
            int count = boom(checkBoom);
            answer += count;

            // 더이상 터트릴게 없다면 break
            if (count == 0) {
                break;
            }

            // 빈 공간 갱신
            updateEmptySpace();
        }


        return answer;
    }

    private void updateEmptySpace() {

        // 0번째 열부터 시작
        for (int k = 0; k < game[0].length; k++) {
            // 빈 공간이 아니면 스택에 담기
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < game.length; i++) {
                if (game[i][k] != '0') {
                    stack.push(game[i][k]);
                }
            }

            // 담은 만큼 다시 행의 바닥부터 채워넣기
            for (int i = game.length - 1; i >= 0; i--) {

                // 스택이 비었다면 빈 공간인 '0' 넣기
                if (stack.isEmpty()) {
                    game[i][k] = '0';
                } else {
                    game[i][k] = stack.pop();
                }
            }
        }

    }

    private int boom(boolean[][] checkBoom) {
        int boomCount = 0;
        for (int i = 0; i < checkBoom.length; i++) {
            for (int j = 0; j < checkBoom[0].length; j++) {
                if (checkBoom[i][j]) {
                    game[i][j] = '0';
                    boomCount++;
                }
            }
        }

        return boomCount;
    }


    private boolean[][] getCanBoomCheck() {
        boolean[][] checkBoom = new boolean[game.length][game[0].length];

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {

                // 빈공간이 아니라면 터트릴 수 있는지 확인
                if (game[i][j] != '0' && checkBoom(game, i, j)) {

                    checkBoom[i][j] = true;
                    for (int k = 0; k < 3; k++) {
                        checkBoom[i + dx[k]][j + dy[k]] = true;
                    }
                }
            }
        }

        return checkBoom;
    }

    private boolean checkBoom(char[][] game, int x, int y) {
        char target = game[x][y];

        // 인접한 3방향이 범위를 벗어나면 false
        if (x + 1 >= game.length || y + 1 >= game[0].length) {
            return false;
        }

        return game[x + 1][y] == target && game[x][y + 1] == target && game[x + 1][y + 1] == target;
    }

}
