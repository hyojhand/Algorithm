package HackerRank;

import java.util.List;

// 3D Surface Area
// 2차원으로 주어진 좌표정보를 3차원으로 바꿨을 때, 6방향(위,아래,좌,우,앞,뒤)에서 바라본 면적의 넓이를 구하는 문제이다.
// 처음 풀때는 위,아래를 제외한 나머지 4방면을 2중 for문으로 행 또는 열의 값이 이전보다 크면 큰만큼의 차이를 면적으로 더해나갔다.
// 하지만, 2중 for문 내에서 4방 탐색을 사용해 간결하게 개선할 수 있었다.
// 먼저, 입력으로 주어진 리스트를 2차원 배열로 변경해준다.
// 1) 위, 아래면적 구하기
// 각 좌표의 값은 1 이상이므로, 위, 아래의 면적은 무조건 행x열이므로, 행열의 곱을 2배로 더해준다.
// 2) 앞,뒤,좌,우 면적 구하기
// 현재 지점에서 4방 탐색을 실시한다.
// 각 지점에서 4방탐색시 배열범위 안이라면, 탐색한 지점보다 현재 값이 더 크다면, 그 차이가 해당 방향의 면적 넓이이므로 더해나간다.
// 배열 범위가 아닌 현재 지점이 테두리라면, 무조건 현재 지점의 값만큼이 해당 방향의 표면 넓이가 된다.
class SurfaceArea3D {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int surfaceArea(List<List<Integer>> A) {
        // 입력을 초기화할 배열
        int H = A.size();
        int W = A.get(0).size();
        int[][] board = new int[H][W];

        // 배열은 무조건 1이상의 값이므로 위, 아래의 표면은 행*열 이다.
        int answer = H * W * 2;

        // 배열 초기화
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = A.get(i).get(j);
            }
        }

        // 앞,뒤,좌,우 탐색
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 배열의 각 위치에서 4방 탐색 실시
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 배열 범위 안이라면
                    if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                        // 근접한 지역보다 클 때, 차이의 값이 표면의 넓이
                        if (board[nx][ny] < board[i][j]) {
                            answer += board[i][j] - board[nx][ny];
                        }
                    } else {
                        // 배열 테두리라면 무조건 해당 넓이가 표면 넓이
                        answer += board[i][j];
                    }
                }
            }
        }

        return answer;
    }
}
