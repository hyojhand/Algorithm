package Programmers.Level1;

public class DartGame {
    public static void main(String[] args) {
        int solution = solution("1S2D*3T");
        System.out.println(solution);
    }

    public static int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        int[] result = new int[3];
        int cnt = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            if (dart[i] >= '0' && dart[i] <= '9') {
                cnt++;
                if (dart[i] == '1' && dart[i + 1] == '0') {
                    result[cnt] = 10;
                    i++;
                } else result[cnt] = dart[i] - '0';
            } else if (dart[i] == 'D') result[cnt] *= result[cnt];
            else if (dart[i] == 'T') result[cnt] *= result[cnt] * result[cnt];
            else if (dart[i] == '*') {
                if (cnt > 0) {
                    result[cnt - 1] *= 2;
                }
                result[cnt] *= 2;
            } else if (dart[i] == '#') result[cnt] *= -1;
        }
        answer = result[0] + result[1] + result[2];

        return answer;
    }
}


