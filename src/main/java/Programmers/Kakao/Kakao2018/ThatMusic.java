package Programmers.Kakao.Kakao2018;

// 2018 KAKAO BLIND RECRUITMENT - [3차] 방금그곡
// 입력 정보를 파싱해서 Music 객체로 바꾼다
// 이때, #을 포함한 음을 임의의 알파벳으로 replace하여 편하게 다룰수 있게 한다. -> C#(H), D#(I), F#(J), G#(K), A#(L) 변환
// 멜로디를 포함하고, 플레이타임이 가장 길다면 해당 제목을 답으로 갱신한다.
// 에러상황1. 메모리초과
// 노래길이보다 재생시간이 길 경우 반복해서 멜로디를 만드는데, while 문을 사용해서 count 변수를 갱신하며 멜로디를 반복해서 더하면 메모리 초과가 발생하여 for문으로 변경하여 해결했다.
// 에러상황2. 재생시간이 노래 전체길이보다 짧을 경우 해당 재생시간만큼만 잘라야 한다.
class ThatMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        // 찾고있는 멜로디
        String findMelody = changeMelody(m);
        // 최대 플레이타임
        int maxPlayTime = 0;

        for (String info : musicinfos) {
            // 입력으로 주어진 정보를 파싱
            Music music = getMusic(info);

            // 멜로디를 포함하고 플레이타임이 가장 길다면
            if (music.melody.contains(findMelody) && maxPlayTime < music.playMinute) {
                maxPlayTime = music.playMinute;
                answer = music.title;
            }
        }

        return answer;
    }

    // Music 파싱
    private Music getMusic(String info) {
        String[] splitInfo = info.split(",");
        String[] startTime = splitInfo[0].split(":");
        String[] endTime = splitInfo[1].split(":");
        String title = splitInfo[2];
        String melody = changeMelody(splitInfo[3]);
        String playMelody = "";

        // 시작시간, 종료시간을 분으로 환산하여 차이 계산
        int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        int minutes = end - start;

        // 길이만큼 나눈 횟수만큼 반복
        for (int i = 0; i < minutes / melody.length(); i++) {
            playMelody += melody;
        }

        // 중간에 짤려있는 분만큼 추가
        int addCount = minutes % melody.length();
        playMelody += melody.substring(0, addCount + 1);

        return new Music(title, playMelody, minutes);
    }

    // #음을 임의의 문자로 replace
    private String changeMelody(String melody) {
        // C#(H), D#(I), F#(J), G#(K), A#(L) 변환
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
        return melody;
    }

    class Music {
        String title, melody;
        int playMinute;

        public Music(String title, String melody, int playMinute) {
            this.title = title;
            this.melody = melody;
            this.playMinute = playMinute;
        }
    }
}