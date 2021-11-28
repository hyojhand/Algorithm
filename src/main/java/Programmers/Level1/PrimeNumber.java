package Programmers.Level1;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = solution(new int[]{1, 2, 7, 6, 4});
        System.out.println(num);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int sum;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum % 2 != 0) answer += isPrime(sum);
                }
            }
        }
        return answer;
    }

    public static int isPrime(int x) {
        boolean flag = true;
        if (x <= 7) return 1;
        for (int i = 3; i < x; i += 2) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) return 1;
        return 0;
    }
}
