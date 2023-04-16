package Programmers.Kakao.Kakako2018;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 다트 게임
// 최소 숫자 1개와 보너스 1개문자를 가지므로, 2개로 문자를 분리한다.
// 10점이 있으므로 분리한 문자가 각각 1, 0이라면 점수를 10점으로 가지고, 보너스를 확인하기 위해 다음 인덱스로 보너스를 계산한다.
// 다음 인덱스가 숫자라면, 옵션이 있으므로 옵션을 계산하고, 옵션이 없다면 점수를 반환한다.
// 옵션에 따라 현재 점수를 변경하고, *옵션이라면, 매개변수로 가져온 이전 점수를 2배로 하여 최종 점수에 더해준다.
// 획득한 점수를 이전 점수 변수(preScore)에 저장하고, 점수다트 결과 문자열과 인덱스가 같을 때까지 반복한다.

// 조건
// * 옵션 : 바로 직전, 본인 점수 2배 -> 첫번째에나오면 본인만 2배, 다른 효과와 중첩가능 (4배)
// # 옵션 : 해당 점수는 마이너스 -> * 중첩가능 (-2배)
// 점수S = 1제곱, 점수D = 2제곱, 점수T = 3제곱
class DartGame {

    int index = 0;
    // 결과에서 점수를 계산할 인덱스
    int answer = 0;

    public int solution(String dartResult) {

        // 직전 점수 저장
        int score = 0;
        // 모든 점수를 계산할때까지 반복
        while (index < dartResult.length()) {
            score = getScore(dartResult, score);
            answer += score;
        }

        return answer;
    }

    private int getScore(String dartResult, int preScore) {
        int score;
        char symbol;
        // 점수,보너스 먼저 계산
        String result = dartResult.substring(index, index + 2);
        index += 2;

        // 10점인 경우 인덱스를 더해서 보너스 확인
        if (result.charAt(0) == '1' && result.charAt(1) == '0') {
            score = 10;
            symbol = dartResult.charAt(index);
            index++;
        } else {
            score = result.charAt(0) - '0';
            symbol = result.charAt(1);
        }

        // bonus 포함 점수 계산
        score = calculateBonusScore(score, symbol);

        // 옵션이 없다면 반환
        if (isNotOption(dartResult)) {
            return score;
        }

        // 옵션 점수 반환
        return getOptionScore(dartResult, score, preScore);
    }

    private int getOptionScore(String dartResult, int score, int preScore) {
        // '#'은 -(마이너스) 곱하기
        if (dartResult.charAt(index) == '#') {
            score = -score;
        } else {
            // '*'은 직전 점수, 현재 점수 2배
            answer += preScore;
            score = score * 2;
        }

        index++;
        return score;
    }

    private boolean isNotOption(String dartResult) {
        if (index == dartResult.length()) {
            return true;
        }

        return '0' <= dartResult.charAt(index) && dartResult.charAt(index) <= '9';
    }

    private int calculateBonusScore(int score, char symbol) {
        if (symbol == 'D') {
            return (int) Math.pow(score, 2);
        }

        if (symbol == 'T') {
            return (int) Math.pow(score, 3);
        }

        return score;
    }

}


/**
 * 다른 풀이
 */
//public static int solution(String dartResult) {
//    char[] dart = dartResult.toCharArray();
//    int answer = 0;
//    int[] result = new int[3];
//    int cnt = -1;
//
//    for(int i = 0; i < dartResult.length(); i++){
//        if(dart[i] >= '0' && dart[i] <= '9'){
//            cnt++;
//            if(dart[i] == '1' && dart[i+1] == '0'){
//                result[cnt] = 10;
//                i++;
//            }
//            else
//                result[cnt] = dart[i] - '0';
//        }
//        else if(dart[i] == 'D') result[cnt] *= result[cnt];
//        else if(dart[i] == 'T') result[cnt] *= result[cnt] * result[cnt];
//        else if(dart[i] == '*'){
//            if(cnt > 0){
//                result[cnt-1] *= 2;
//            }
//            result[cnt] *= 2;
//        }
//        else if(dart[i] == '#') result[cnt] *= -1;
//
//    }
//    answer = result[0] + result[1] + result[2];
//
//    return answer;
//}