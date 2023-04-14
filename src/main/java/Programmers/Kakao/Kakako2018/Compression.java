package Programmers.Kakao.Kakako2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT [3차] 압축
// 알파벳 전체를 1부터 HashMap으로 저장한다.
// 긴 문자열 부터 포함하는지 확인하는데, 문자열의 끝부터 지금까지 처리한 길이까지 substring 하면서 확인한다.
// 포함하는 문자가 나오면 해당 인덱스를 리스트에 저장하고, 처리한 문자의 길이를 갱신해준다.
// 처리한 문자의 길이가 입력의 총 길이보다 작으면 뒤의 문자가 남았으니 다음 문자열을 포함한 문자를 저장하고 반복한다.
public class Compression {

    public int[] solution(String msg) {
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String word = String.valueOf((char) ('A' + i));
            words.put(word, words.size() + 1);
        }

        List<Integer> answers = new ArrayList<>();

        // 처리한 문자의 길이
        int completeLength = 0;

        // 입력을 모두 처리할때까지 반복한다.
        while (completeLength < msg.length()) {

            // 처리해야할 문자열 중에서 가장 긴 문자열 찾기
            for (int i = msg.length(); i >= completeLength; i--) {

                String word = msg.substring(completeLength, i);

                // 문자열을 포함하면
                if (words.containsKey(word)) {
                    // 해당 문자의 색인 번호 저장
                    answers.add(words.get(word));

                    // 입력에서 해당 문자는 제거 (처리한 길이는 마지막 인덱스)
                    completeLength = i;

                    // 남아있는 글자가 있다면, 앞의 문자 + 뒤의 한글자에 해당하는 단어 등록
                    if (completeLength < msg.length()) {
                        String newWord = word + msg.charAt(completeLength);
                        words.put(newWord, words.size() + 1);
                    }

                    break;
                }
            }
        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
