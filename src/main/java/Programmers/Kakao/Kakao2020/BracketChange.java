package Programmers.Kakao.Kakao2020;

import java.util.*;
// 2020 KAKAO BLIND RECRUITMENT - 괄호 변환
// 주어진 순서대로 구현

// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//  4-3. ')'를 다시 붙입니다.
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//  4-5. 생성된 문자열을 반환합니다.

class BracketChange {
    public String solution(String p) {
        return seperateRepeat(p);
    }

    private String seperateRepeat(String value) {
        if (value.equals("")) {
            return "";
        }

        String result = "";
        char[] brackets = value.toCharArray();

        // 1. 균형잡힌 문자열로 2개 분리, 분리할 지점의 index를 반환
        int index = getBalanceIndex(brackets);
        String seperateA = value.substring(0, index);
        String seperateB = value.substring(index);

        // v의 재귀적 실행 결과
        String bResult = seperateRepeat(seperateB);

        // u가 올바른 문자열이면 v의 재귀적 실행 결과를 u에 이어붙이고 반환
        if (isRightString(seperateA.toCharArray())) {
            result = seperateA + bResult;
        } else {
            // u가 올바른 문자열이 아니면
            // '(' + v의 재귀적 실행 결과 + ')'를 진행
            result = "(" + bResult + ")";

            // u의 첫번째, 마지막문자 제거이후 괄호방향 뒤집고, 결과에 이어붙이기
            String temp = seperateA.substring(1, seperateA.length() - 1);
            // 괄호방향 뒤집기
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '(') {
                    result += ")";
                } else {
                    result += "(";
                }
            }
        }
        return result;
    }


    private int getBalanceIndex(char[] arr) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount == closeCount) {
                return i + 1;
            }
        }

        return arr.length;
    }

    private boolean isRightString(char[] arr) {
        // 빈 문자열이면 true 반환
        if (arr.length == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char value : arr) {
            if (value == '(') {
                stack.push(value);
            }

            if (value == ')') {
                // 첫 문자열이 닫혀있다면 올바른 문자열이 아니다
                if (stack.size() == 0) {
                    return false;
                }

                // 괄호가 열려있으면 삭제, 그렇지 않으면 올바른 문자열이 아니다
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // 모두 닫힐 수 있으면 올바른 문자열이므로, true 반환
        return true;
    }
}
