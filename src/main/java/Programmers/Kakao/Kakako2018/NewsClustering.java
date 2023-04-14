package Programmers.Kakao.Kakako2018;

import java.util.*;
import java.util.regex.Pattern;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 뉴스 클러스터링
// 각 문자열을 2개 단위로 substring하고, 대문자로 통일시켜준다. 또한, 영문자로 구성된 문자만 사용하기 위해 Pattern으로 확인한다.
// 영어로 구성된 단어를 key로 가지고, 중복 횟수를 value로 가지는 HashMap에 저장해간다.
// 첫번째 문자의 집합을 확인하며 다른 문자열에도 포함하는 값이라면, 교집합은 최소값으로 더하고, 합집합에는 최대값으로 더한다.
// 아예 포함하지 않는 값은 합집합에 더한다. 비교가 끝난 다른 문자열의 문자는 0으로 초기화
// 남은 문자열의 문자들 중 포함되지 않는 문자들은 모두 합집합으로 저장한다.
// 최종적으로 합집합과 교집합을 활용한 답을 계산한다.
public class NewsClustering {

    String wordPattern = "^[A-Z]{2}$";

    public int solution(String str1, String str2) {

        // 단어를 key, 중복 횟수를 value로 가지는 HashMap에 저장
        HashMap<String, Integer> memory = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i + 2).toUpperCase();

            // 영단어가 아니라면 continue
            if (!Pattern.matches(wordPattern, word)) {
                continue;
            }

            // 있다면 + 1, 없다면 1로 저장한다
            memory.put(word, memory.getOrDefault(word, 0) + 1);
        }

        // 두번째 문자도 똑같이 저장
        HashMap<String, Integer> otherMemory = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i + 2).toUpperCase();

            if (!Pattern.matches(wordPattern, word)) {
                continue;
            }
            otherMemory.put(word, otherMemory.getOrDefault(word, 0) + 1);
        }

        int duplicateCount = 0; // 교집합 카운트
        int joinCount = 0; // 합집합 카운트

        // 첫번째 문자의 집합을 확인하며 중복되는 값은 최소값을 구해 더하고, 합집합에는 최대값으로 더한다.
        // 아예 포함하지 않는 값은 합집합에 더한다.
        for (String key : memory.keySet()) {
            // 양쪽 문자열 둘다 포함한다면
            if (otherMemory.containsKey(key)) {

                // 교집합에는 최소값 저장
                duplicateCount += Math.min(memory.get(key), otherMemory.get(key));
                joinCount += Math.max(memory.get(key), otherMemory.get(key));

                // 비교가 끝난 다른 문자열의 문자는 0으로 초기화
                otherMemory.put(key, 0);
            } else {
                // 가지고 있는 개수만큼 합집합에만 저장
                joinCount += memory.get(key);
            }
        }

        // 남은 문자열의 문자들 중 포함되지 않는 문자들은 모두 합집합으로 저장
        for (String key : otherMemory.keySet()) {
            joinCount += otherMemory.get(key);
        }

        // 공집합은 1 반환
        if (joinCount == 0) {
            return 65536;
        }

        return duplicateCount * 65536 / joinCount;
    }

}
