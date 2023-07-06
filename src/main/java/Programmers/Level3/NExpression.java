package Programmers.Level3;

import java.util.*;

// N으로 표현
public class NExpression {
    public int solution(int N, int number) {
        int answer = -1;

        Set<Integer>[] numbers = new Set[9];
        for (int i = 1; i <= 8; i++) {
            numbers[i] = new HashSet<>();
        }

        // 1개로 만들 수 있는 수는 N
        numbers[1].add(N);

        // 2부터 8까지 경우의 수만큼 탐색
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (i <= j) {
                    break;
                }

                calculateNumber(numbers[i], numbers[j], numbers[i - j]);
                calculateNumber(numbers[i], numbers[i - j], numbers[j]);
            }

            // N을 n번 반복한 숫자도 포함시켜준다
            String repeatNumber = Integer.toString(N).repeat(i);
            numbers[i].add(Integer.parseInt(repeatNumber));

            for (Integer findNumber : numbers[i]) {
                if (findNumber == number) {
                    return i;
                }
            }
        }

        return answer;
    }

    private void calculateNumber(Set<Integer> numbers, Set<Integer> a, Set<Integer> b) {
        for (int num1 : a) {
            for (int num2 : b) {
                numbers.add(num1 + num2);
                numbers.add(num1 - num2);
                numbers.add(num1 * num2);
                if (num2 != 0) {
                    numbers.add(num1 / num2);
                }
            }
        }
    }
}
