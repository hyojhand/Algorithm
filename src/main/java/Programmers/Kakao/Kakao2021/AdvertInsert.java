package Programmers.Kakao.Kakao2021;

// 2021 KAKAO BLIND RECRUITMENT - 광고 삽입
// 시간의 시,분,초를 초 단위로 변환해서 사용한다.
// 최대 100시간 미만이기 때문에, 각 구간을 초단위로 나눈 배열의 최대 크기를 360000으로 설정한다.
// 재생 구간의 초단위로 배열에 로그횟수만큼 카운트해준다.
// 이후, 누적합으로 1초씩 앞의 카운트를 빼고, 마지막 카운트를 더해주면서 가장 많은 재생횟수를 가지는 시작 시간을 계산한다.
// 얻은 시작 시간을 HH:MM:SS 형식으로 반환한다.
public class AdvertInsert {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] count = new int[360000];

        for (String log : logs) {
            String[] times = log.split("-");
            int start = getTimeToSecond(times[0]);
            int end = getTimeToSecond(times[1]);

            for (int i = start; i < end; i++) {
                count[i]++;
            }
        }

        int playTime = getTimeToSecond(play_time);
        int advTime = getTimeToSecond(adv_time);

        long maxCount = 0;
        int answerTime = 0;
        for (int i = 0; i < advTime; i++) {
            maxCount += count[i];
        }

        long sumCount = maxCount;
        int startTime = 0;
        for (int i = advTime; i < playTime; i++) {
            sumCount = sumCount - count[startTime] + count[i];
            startTime++;
            if (maxCount < sumCount) {
                maxCount = sumCount;
                answerTime = startTime;
            }
        }

        return getTimeToString(answerTime);
    }

    private String getTimeToString(int time) {
        int hour = time / 3600;
        int minute = (time % 3600) / 60;
        int second = (time % 3600) % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    private int getTimeToSecond(String times) {
        String[] time = times.split(":");

        int hour = Integer.parseInt(time[0]) * 3600;
        int minute = Integer.parseInt(time[1]) * 60;
        int second = Integer.parseInt(time[2]);
        return hour + minute + second;
    }
}
