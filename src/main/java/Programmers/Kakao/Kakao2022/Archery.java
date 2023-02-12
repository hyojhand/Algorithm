package Programmers.Kakao.Kakao2022;

// 2022 KAKAO BLIND RECRUITMENT - 양궁대회
class Archery {
    // 점수 차이
    int diffMax = -1;
    int[] answer = new int[11];
    int[] ryan = new int[11];
    int[] apeach;
    int totalArrow;

    public int[] solution(int n, int[] info) {
        apeach = info;
        totalArrow = n;

        dfs(0, n);

        if (diffMax == -1) {
            answer = new int[]{-1};
        }

        return answer;
    }

    private void dfs(int start, int arrow) {
        // 화살을 다썼을때
        if (arrow == 0) {
            // 점수차 확인
            int diff = getDifferenceScore();
            // 라이언이 이긴다면
            if (diff > 0) {
                if (diffMax < diff) {
                    diffMax = diff;
                    answer = ryan.clone();
                    return;
                }

                if (diffMax == diff) {
                    // 낮은 점수가 가장 많은 경우를 선택
                    for (int i = 10; i >= 0; i--) {
                        if (ryan[i] > answer[i]) {
                            answer = ryan.clone();
                            return;
                        } else if (ryan[i] < answer[i]) {
                            return;
                        }
                    }
                }

            }
            return;
        }


        for (int i = start; i <= 10; i++) {
            // 마지막인데 화살이 남았으면, 화살다쓰기
            if (i == 10) {
                ryan[i] = arrow;
                dfs(start + 1, 0);
                ryan[i] = 0;
            }

            int useArrow = apeach[i] + 1;
            if (arrow >= useArrow) {
                ryan[i] = useArrow;
                dfs(i + 1, arrow - useArrow);
                ryan[i] = 0;
            }

        }
    }

    private int getDifferenceScore() {
        int sum = 0;
        for (int i = 0; i < apeach.length; i++) {
            // 라이언이 이기면 +, 어피치가 이기면 -
            if (apeach[i] < ryan[i]) {
                sum += (10 - i);
            } else if (apeach[i] > ryan[i]) {
                sum -= (10 - i);
            }
        }

        // 라이언의 점수 - 어피치 점수
        return sum;
    }
}