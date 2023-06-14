package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 KAKAO BLIND RECRUITMENT - 기둥과 보 설치
// board[x][y][structure] : x,y 좌표에서 건축물이 존재하는지 저장하는 3차원 boolean 배열을 사용한다.
// 규칙을 만족하지는 boolean을 반환하는 메서드를 만들고, 기둥,보에 따라 설치를 위해 만족하는 조건들을 확인하고, 하나라도 만족한다면 true를 반환한다.
// 설치 시, 해당 좌표에서 건축물에 따라 규칙을 만족하면 해당 위치의 건축물을 설치한다.
// 삭제 시, 먼저 해당 좌표에서 건축물을 제거하고, 문제가 있을 위치의 건축물을 확인하면서 하나라도 문제가 있다면 삭제하지 않고 돌려놓는다.
// 1) 기둥 삭제: 위쪽 기둥 확인, 위쪽 보 확인, 위쪽 좌측 보 확인
// 2) 보 삭제: 현재 기둥 확인, 우측 기둥 확인, 좌측 보 확인, 우측 보 확인
// 모든 배열을 탐색하며 건축된 건축물과 좌표를 리스트에 저장하고 요구사항대로 정렬해준다.
// 입력으로 주어지는 y,x로 주어지므로 항상 주의해서 확인하자!
public class PillarCarpetConstruct {
    private static final int PILLAR = 0;
    private static final int CARPET = 1;
    boolean[][][] board;

    public int[][] solution(int n, int[][] build_frame) {

        board = new boolean[n + 1][n + 1][2];
        for (int[] frame : build_frame) {
            int y = frame[0];
            int x = frame[1];
            int structure = frame[2];
            int command = frame[3];

            if (command == 0) {
                // 규칙을 만족하지 못하면 복구
                board[x][y][structure] = false;

                // '기둥'일때
                if (structure == PILLAR) {
                    // 위쪽 기둥 있다면 확인
                    if (x < n && board[x + 1][y][PILLAR] && !isRule(x + 1, y, PILLAR, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }

                    // 위쪽 보 확인
                    if (x < n && board[x + 1][y][CARPET] && !isRule(x + 1, y, CARPET, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }

                    // 위쪽 좌측 보 확인
                    if (x < n && y >= 1 && board[x + 1][y - 1][CARPET] && !isRule(x + 1, y - 1, CARPET, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }
                }

                // '보'일때
                if (structure == CARPET) {
                    // 현재 기둥 확인
                    if (board[x][y][PILLAR] && !isRule(x, y, PILLAR, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }

                    // 우측 기둥 확인
                    if (y < n && board[x][y + 1][PILLAR] && !isRule(x, y + 1, PILLAR, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }

                    // 좌측 보 확인
                    if (y >= 1 && board[x][y - 1][CARPET] && !isRule(x, y - 1, CARPET, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }

                    // 우측 보 확인
                    if (y < n && board[x][y + 1][CARPET] && !isRule(x, y + 1, CARPET, n)) {
                        board[x][y][structure] = true;
                        continue;
                    }
                }

            } else {
                // 규칙을 지킨다면 건축하기
                if (isRule(x, y, structure, n)) {
                    board[x][y][structure] = true;
                }
            }
        }

        List<Structure> structures = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (board[i][j][k]) {
                        structures.add(new Structure(i, j, k));
                    }
                }
            }
        }

        Collections.sort(structures, (o1, o2) -> {
            if (o1.y == o2.y) {
                if (o1.x == o2.x) {
                    return o1.build - o2.build;
                }
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });


        int[][] answer = new int[structures.size()][3];
        for (int i = 0; i < structures.size(); i++) {
            answer[i][0] = structures.get(i).y;
            answer[i][1] = structures.get(i).x;
            answer[i][2] = structures.get(i).build;
        }

        return answer;
    }

    private boolean isRule(int x, int y, int structure, int n) {
        // 기둥
        if (structure == PILLAR) {
            // 바닥에 위치
            if (x == 0) return true;

            // 보의 끝에 위치
            if ((y >= 1 && board[x][y - 1][CARPET]) || board[x][y][CARPET]) return true;

            // 기둥 위에 위치
            if (x >= 1 && board[x - 1][y][PILLAR]) return true;
        }

        // 보
        if (structure == CARPET) {
            // 보의 한쪽 끝 아래가 기둥
            if ((x >= 1 && board[x - 1][y][PILLAR]) ||
                    (x >= 1 && y < n && board[x - 1][y + 1][PILLAR])) return true;

            // 양쪽이 보
            if (y >= 1 && y < n && board[x][y - 1][CARPET] && board[x][y + 1][CARPET]) return true;
        }

        return false;
    }

    class Structure {
        int x, y, build;

        public Structure(int x, int y, int build) {
            this.x = x;
            this.y = y;
            this.build = build;
        }
    }
}
