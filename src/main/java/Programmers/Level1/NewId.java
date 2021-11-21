package Programmers.Level1;

public class NewId {
    public static void main(String[] args) {
        String answer = solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(answer);
    }

    public static String solution(String new_id) {
        String answer = "";
        String step1 = new_id.toLowerCase();

        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");
        String step3 = step2.replaceAll("[.]{2,}", ".");
        String step4 = step3.replaceAll("^[.]|[.]$", "");

        String step5 = step4;
        if (step5.equals(""))
            step5 += "a";

        String step6 = step5;
        if (step6.length() > 15) {
            step6 = step6.substring(0, 15);
            step6 = step6.replaceAll("[.]$", "");
        }

        String step7 = step6;
        if (step7.length() <= 2) {
            while (step7.length() < 3) {
                step7 += step7.charAt(step7.length() - 1);
            }
        }

        answer = step7;


        return answer;
    }
}
