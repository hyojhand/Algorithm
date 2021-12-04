package Programmers.Level1;

public class SecretMap {
    public static void main(String[] args) {
        String[] ans = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(ans);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            str = String.format("%" + n + "s", str);
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            answer[i] = str;
        }

        return answer;
    }
}
