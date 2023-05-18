package HackerRank;

// 글자의 사전 순서대로 크기가 크다고 할 수 있다.
// 2가지 조건을 모두 충족하는 글자를 구해라, 없다면 no answer를 출력한다.
// 1. 최초 단어보다 반드시 커야한다. It must be greater than the original word
// 2. 첫번째 조건을 만족하는 단어중에 가장 작아야한다. It must be the smallest word that meets the first condition

// 먼저, 입력으로 받은 문자를 배열로 바꿔서 다룬다.
// 1. 마지막 인덱스의 앞글자부터 뒤에 자기보다 큰 숫자가 있는지 확인하며 바꿀 인덱스를 찾는다.
// 0번인덱스까지 탐색하며 없다면, 최초 초기화한 -1 그대로이며, no answer를 출력한다.
// 2. 바꿀 인덱스를 찾았다면, 해당 인덱스부터 뒤를 전부 탐색하며 가장 작은 단어와 인덱슬르 찾는다.
// 찾은 인덱스와 문자의 값을 바꿔준다.
// 바꾼 인덱스까지 자르고 앞부분은 그대로 가져간다.
// 이후 뒤의 문자는 배열로 만들어 정렬해주고, 다시 이어붙여주면 두 조건을 만족하는 최소값이 나온다.

import java.util.Arrays;

class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        char[] words = w.toCharArray();
        int len = words.length;

        int index = -1; // 바꾸기 시작할 인덱스
        int changeIndex = -1; // 바꿀 최소 인덱스
        for (int i = len - 2; i >= 0; i--) {
            char word = words[i];

            for (int j = i + 1; j < len; j++) {
                if (word < words[j]) {
                    // 처음 찾았다면 바꾸기 시작할 인덱스 갱신
                    if (changeIndex == -1) {
                        index = i;
                        changeIndex = j;
                    } else {
                        // 최소값의 인덱스를 갱신
                        if (words[j] < words[changeIndex]) {
                            changeIndex = j;
                        }
                    }
                }
            }

            // 인덱스를 찾았다면 문자 변경
            if (index != -1) {
                // 해당 인덱스들의 문자 변경
                char temp = words[index];
                words[index] = words[changeIndex];
                words[changeIndex] = temp;
                break;
            }
        }

        // 인덱스를 찾지 못했다면 no answer 출력
        if (index == -1) {
            return "no answer";
        }

        // 위치를 바꾼 새로운 단어
        String newWord = String.valueOf(words);

        // 바꾼 인덱스의 앞부분은 그대로 가져간다
        String answer = newWord.substring(0, index + 1);

        // 바꾼 인덱스의 뒷부분은 배열로 변경해 정렬해주고 이어붙인다
        char[] splitAnswers = newWord.substring(index + 1).toCharArray();
        Arrays.sort(splitAnswers);
        for (char splitAnswer : splitAnswers) {
            answer += splitAnswer;
        }

        return answer;
    }
}
