package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 카카오 인턴십 - 보석 쇼핑
// Map에 넣으면서 개수 확인, 충족시 앞의 번호를 뒤로 당기면서 끝까지 탐색하여 최소 구간 구하기 - 투 포인터
public class GemShopping {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        // 전체 보석 수 확인
        HashSet<String> totalGems = new HashSet<>();
        for (String gem : gems) {
            totalGems.add(gem);
        }
        int totalCount = totalGems.size();

        // 두 수의 차이
        int diff = Integer.MAX_VALUE;

        // 시작, 끝 인덱스
        int start = 0;
        int end = 0;
        // 정답 시작, 끝 인덱스
        int leftAnswer = 0;
        int rightAnswer = 0;

        // 쇼핑 목록 저장 Map
        HashMap<String, Integer> shopping = new HashMap<>();

        while (true) {
            if (shopping.size() == totalCount) {
                // 모든 목록을 가지고 있다면 앞의 인덱스를 뒤로 당긴다.
                shopping.put(gems[start], shopping.get(gems[start]) - 1);
                // 0이되면 Shopping Map에서 삭제
                if (shopping.get(gems[start]) == 0) {
                    shopping.remove(gems[start]);
                }
                start++;
            } else if (end == gems.length) {
                // 끝까지 갔는데 더이상 줄일 수 없을 때 break
                break;
            } else {
                shopping.put(gems[end], shopping.getOrDefault(gems[end], 0) + 1);
                end++;
            }

            // 모든 목록을 가지고 있고 최소 거리보다 작다면
            if (shopping.size() == totalCount && (end - start) < diff) {
                diff = end - start;
                leftAnswer = start + 1; // 인덱스 수에서 정답을 위해 +1로 맞추기
                rightAnswer = end; // 이미 앞에서 +1 되었다
            }

        }

        answer[0] = leftAnswer;
        answer[1] = rightAnswer;

        return answer;
    }

}
