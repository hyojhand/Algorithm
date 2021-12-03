package Programmers.Level2;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        String answer = solution(new int[]{6, 10, 2});
        System.out.println(answer);
    }

    static String solution(int[] numbers) {
        String answer = "";
        String[] str_numbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str_numbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str_numbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
                // 내림차순 : return (o2+o1).compareTo(o1+o2);
                // 오름차순 : return (o1+o2).compareTo(o1+o2);
            }

        });

        if (str_numbers[0].equals("0")) {
            answer = "0";
        } else {
            for (int j = 0; j < str_numbers.length; j++) {
                answer += str_numbers[j];
            }
        }


        return answer;
    }
}
