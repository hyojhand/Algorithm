package Programmers.Level2;

public class Lcm {
    public static void main(String[] args) {
        int answer = solution(new int[]{2, 6, 8, 14});
        System.out.println(answer);
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 0; i < arr.length; i++)
            answer = lcm(answer, arr[i]);

        return answer;
    }

    public static int gcd(int x, int y) {
        int tmp;
        if (y > x) {
            tmp = x;
            x = y;
            y = tmp;
        }

        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    public static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }
}


