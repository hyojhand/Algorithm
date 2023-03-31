package Programmers.Kakao.Kakao2019;

// 2019 카카오 개발자 겨울 인턴십 - 징검다리 건너기
// stones 배열의 크기는 1 이상 200,000 이하, stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수
// 1. k구간만큼의 최대값을 구하고, 그 값들 중에 최소값으로 완전탐색 - 당연히 시간초과
// 2. 이분탐색 - 이동가능한 인원의 수를 최소, 최대로 잡고 이분탐색하며 최대값 탐색
public class SteppingStone {

    public int solution(int[] stones, int k) {
        int answer = 0;
        // 최소, 최대 인원수
        int min = 1;
        int max = 200000000;

        while (min <= max) {
            int mid = (min + max) / 2;

            // 이동 가능한 인원이면 최소값을 중간값 + 1로 초기화하고, 최대값
            if (isCrossStone(mid, stones, k)) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return answer;
//        return max;
    }

    private boolean isCrossStone(int people, int[] stones, int k) {
        int count = 0;
        // 연속된 count가 k라면 건널 수 없으므로, false 반환
        for (int stone : stones) {
            if (stone < people) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                return false;
            }
        }
        return true;
    }
}
