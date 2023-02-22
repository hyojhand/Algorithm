package Programmers.Kakao.Kakao2022;

import java.util.*;

// 2022 KAKAO TECH INTERNSHIP - 성격 유형 검사하기
class PersonalityTypeTest {
    String[] categories = {"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {

        // 점수를 저장할 HashMap
        HashMap<Character, Integer> scores = new HashMap<>();

        for (int i = 0; i < choices.length; i++) {
            // 주어진 유형 순서에서
            int choice = choices[i];
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            // 4보다 작으면 앞의 유형에 점수
            if (choice < 4) {
                scores.put(first, scores.getOrDefault(first, 0) + 4 - choice);
            }

            // 4보다 크면 뒤의 유형에 점수
            if (choice > 4) {
                scores.put(second, scores.getOrDefault(second, 0) + choice - 4);
            }
        }

        String answer = "";

        // 점수가 큰 유형을 넣는다. (같으면 앞의 유형)
        for (String category : categories) {
            char first = category.charAt(0);
            char second = category.charAt(1);
            answer += scores.getOrDefault(first, 0) >= scores.getOrDefault(second, 0) ? first : second;
        }

        return answer;
    }
}