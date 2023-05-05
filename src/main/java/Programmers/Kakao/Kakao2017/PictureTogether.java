package Programmers.Kakao.Kakao2017;

// 2017 카카오코드 본선 - 단체사진 찍기
// dfs로 8명의 친구가 위치할 수 있는 모든 경우의 수 탐색
// 8명이 모두 위치했다면, 각 조건을 반복문으로 돌며 하나라도 만족하지 않는 조건이 있다면 false
// 모든 조건을 만족한다면 최종 결과에 + 1하여 결과값 반환
class PictureTogether {
    private int answer = 0;
    private final String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private boolean[] visited;

    public int solution(int n, String[] data) {

        // 방문 여부 체크
        visited = new boolean[8];
        // dfs 탐색
        dfs("", data);

        return answer;
    }

    private void dfs(String name, String[] data) {
        // 모두 위치했을때
        if (name.length() == 8) {
            if (isRightPosition(name, data)) {
                answer++;
            }
            return;
        }

        // 방문하지 않은 친구의 이름을 더해 dfs 탐색
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(name + names[i], data);
                visited[i] = false;
            }
        }
    }

    private boolean isRightPosition(String name, String[] data) {
        for (String condition : data) {

            // from, to가 위치한 인덱스
            int fromIndex = name.indexOf(condition.charAt(0));
            int toIndex = name.indexOf(condition.charAt(2));
            // 수식, 둘 사이의 실제 인덱스 차이
            char symbol = condition.charAt(3);
            int distance = condition.charAt(4) - '0' + 1;

            // 현재 둘 사이의 거리
            int nowDistance = Math.abs(fromIndex - toIndex);

            // 조건을 만족하지 않으면 false 반환
            if (symbol == '=') {
                if (nowDistance != distance) {
                    return false;
                }
            } else if (symbol == '<') {
                if (nowDistance >= distance) {
                    return false;
                }
            } else if (symbol == '>') {
                if (nowDistance <= distance) {
                    return false;
                }
            }
        }

        return true;
    }
}
