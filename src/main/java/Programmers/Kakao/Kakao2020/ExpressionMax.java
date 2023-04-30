package Programmers.Kakao.Kakao2020;

import java.util.*;

// 2020 카카오 인턴십 - 수식 최대화
// 연산자, 숫자를 나누어 리스트로 가지고 있는다.
// 이후 연산자의 순서를 dfs로 지정하며 모든 순서가 지정되면(order = 3) 연산자 순서대로 계산한다.
// 연산자와 같은 인덱스의 숫자, 다음 숫자를 삭제하며 둘을 계산한다.
// 계산한 연산자도 함께 삭제해주며, 연산자의 크기를 고려해 반복문 인덱스도 줄여준다.
// 최종 계산결과와 최대값을 비교하여 정답을 구한다.
// 숫자의 자료형은 long으로 지정해야한다.
class ExpressionMax {
    char[] operators = {'+', '-', '*'};
    long answer = 0;

    List<Long> numbers = new ArrayList<>();
    List<Character> symbols = new ArrayList<>();
    Character[] orderSymbols = new Character[3];
    boolean[] visited = new boolean[3];

    public long solution(String expression) {

        String number = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // 숫자라면 이어붙이기
            if (ch >= '0' && ch <= '9') {
                number += ch;
            } else {
                // 연산자가 나오면 연산자 추가 및 지금까지 숫자 추가이후 초기화
                numbers.add(Long.parseLong(number));
                symbols.add(ch);
                number = "";
            }
        }

        // 마지막 숫자 추가
        numbers.add(Long.parseLong(number));

        dfs(0);

        return answer;
    }

    private void dfs(int order) {
        // 순서 3개가 모두 지정되면 계산
        if (order == 3) {

            List<Long> numberList = new ArrayList<>(numbers);
            List<Character> symbolList = new ArrayList<>(symbols);

            // 연산자 우선순위대로 반복
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < symbolList.size(); j++) {
                    // j번째 연산자가 순서에 맞다면 계산
                    if (orderSymbols[i] == symbolList.get(j)) {

                        // 연산자, 숫자는 삭제하면서 계산하기
                        long result = calculate(numberList.remove(j), numberList.remove(j), symbolList.remove(j));

                        // 계산한 숫자를 그 위치에 넣기
                        numberList.add(j, result);

                        // 줄어든 연산자 고려하여 j--
                        j--;
                    }
                }
            }

            // 1개남은 값이 최종 계산결과이므로, 최대값 계산
            answer = Math.max(answer, Math.abs(numberList.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // order 순서의 연산자는 operators[i]이다.
                orderSymbols[order] = operators[i];
                dfs(order + 1);
                visited[i] = false;
            }
        }

    }

    private long calculate(long number1, long number2, char symbol) {
        if (symbol == '+') {
            return number1 + number2;
        }

        if (symbol == '-') {
            return number1 - number2;
        }

        return number1 * number2;
    }
}
