package Programmers.Level1;

public class Keypad {
    public static void main(String[] args) {
        String answer = solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println(answer);

    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        int left_dis, right_dis;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                if (num == 0) num = 11;
                left_dis = Math.abs(num - left) / 3 + Math.abs(num - left) % 3;
                right_dis = Math.abs(num - right) / 3 + Math.abs(num - right) % 3;
                if (left_dis == right_dis) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = num;
                    } else {
                        sb.append("L");
                        left = num;
                    }
                } else if (left_dis > right_dis) {
                    sb.append("R");
                    right = num;
                } else if (left_dis < right_dis) {
                    sb.append("L");
                    left = num;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

}
