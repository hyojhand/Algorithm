package Programmers.Kakao.Kakako2018;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 비밀지도
// 각 숫자를 2진수로 변경한다 - Integer.toString(number, 2)
// 변경한 2개의 이진수 각 자릿수를 OR 연산하여 1이라면 "#"을, 그렇지 않다면 공백을 더해간다.
class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 숫자를 이진수로 변경
            String binaryString = getBinaryString(arr1[i], n);
            String binaryString2 = getBinaryString(arr2[i], n);

            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (binaryString.charAt(k) == '1' || binaryString2.charAt(k) == '1') {
                    builder.append("#");
                } else {
                    builder.append(" ");
                }
            }

            answer[i] = builder.toString();
        }

        return answer;
    }

    private static String getBinaryString(int number, int n) {
        String binaryString = Integer.toString(number, 2);

        if (binaryString.length() < n) {
            int dif = n - binaryString.length();

            for (int i = 0; i < dif; i++) {
                binaryString = "0" + binaryString;
            }

        }
        return binaryString;
    }
}

/**
 * 다른 풀이
 */
//    public static String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] answer = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
//            str = String.format("%" + n + "s", str);
//            str = str.replaceAll("1", "#");
//            str = str.replaceAll("0", " ");
//            answer[i] = str;
//        }
//
//        return answer;
//    }


