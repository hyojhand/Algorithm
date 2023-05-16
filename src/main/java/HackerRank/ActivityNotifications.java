package HackerRank;

import java.util.List;

// FraudulentActivityNotifications
// 최초 단순 정렬은 최악의 경우 N만큼 정렬을 하면서 시간초과발생
// 200개의 한정된 값을 사용하기 때문에 "counting sort"를 사용할 수 있다.
// 값을 가지는 범위만큼의 카운팅 배열을 만들어 해당 값의 배열에 개수를 더한다.
// 최초 d 만큼의 값만 카운팅하고, 중간값을 구해 다음 인덱스의 값보다 중간값 * 2가 작거나 같다면 결과값을 + 1 해준다.
// 중간값을 구할때, 범위의 길이가 홀수, 짝수일 경우를 고려해 조건문으로 계산해준다.
// 홀수일 때는, 2로 나눈 인덱스에서 + 1을 한 인덱스가 중간 인덱스임을 고려한다.
// 짝수일 때는, 다음 인덱스의 값을 포함하는 카운팅 배열의 값이 나올때 까지 while 문으로 반복해준다.
// 비교를 마친후, 비교하는 범위의 첫 값을 가지는 카운팅 배열을 -1 해주고, 다음 인덱스의 값을 가지는 카운팅 배열을 + 1 해주며 반복한다.
class ActivityNotifications {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int answer = 0;

        // counting sort 사용 - 최대값이 200이므로 0부터 시작하는 201개의 배열 생성
        int[] numbers = new int[201];
        // d개까지만 숫자의 값을 counting 배열에 더해준다.
        for (int i = 0; i < d; i++) {
            numbers[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++) {
            // 중간값 탐색
            double mid = getMid(numbers, d);

            // 다음 인덱스의 값 >= 중간값 * 2 라면, 최종 개수를 더한다.
            if (expenditure.get(i) >= mid * 2) {
                answer++;
            }

            // 현재 d개의 카운팅 배열중에 처음 값은 빼고, 다음 값을 카운팅 배열로 넣는다.
            numbers[expenditure.get(i - d)]--;
            numbers[expenditure.get(i)]++;
        }

        return answer;
    }

    private static double getMid(int[] numbers, int d) {
        // 중간값 mid
        double mid = 0;

        // 중간을 의미하는 인덱스
        int midIndex = d / 2;
        // 홀수라면 + 1 해준 값이 중간 인덱스
        if (d % 2 != 0) {
            midIndex++;
        }

        // 정렬순으로 지나온 개수
        int count = 0;

        // 현재 counting 배열을 탐색하며 중간값 탐색
        for (int i = 0; i < numbers.length; i++) {
            // 정렬 순으로 개수 더하기
            count += numbers[i];

            // 중간 인덱스를 포함하는 구간의 값이라면
            if (count >= midIndex) {
                // 중간값 갱신
                mid = i;

                // 짝수라면 중간값 다음 인덱스의 값을 더해 2로 나누어준다.
                if (d % 2 == 0) {

                    // 중간 인덱스 다음을 포함하는 값이 나올 때까지 반복
                    while (count < midIndex + 1) {
                        i++;
                        count += numbers[i];
                    }

                    // 해당 값을 더해 2로 나누어 중간값 계산
                    mid += i;
                    mid /= 2;
                }

                break;
            }
        }
        return mid;
    }
}