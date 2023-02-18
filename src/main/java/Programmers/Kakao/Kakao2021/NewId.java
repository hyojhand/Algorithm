package Programmers.Kakao.Kakao2021;

// 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
class NewId {
    public String solution(String new_id) {

        // step1 소문자 치환
        new_id = new_id.toLowerCase();

        // step2 소문자,숫자, - _ . 제외 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // step3 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        // replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("[.]+", ".");

        // step4 마침표(.)가 처음이나 끝이라면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // step5 빈 문자열이면, new_id에 "a"를 대입
        if (new_id.equals("")) {
            new_id = "a";
        }

        // step6 길이가 16자 이상이면, new_id의 첫 15개 문자 제외 나머지 문자 모두 제거
        // 제거후 마침표가 끝에 위치하면, 끝에 위치한 마침표도 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15).replaceAll("[.]$", "");
        }

        // step7 길이가 2 이하면, 마지막 문자를 길이 3까지 반복
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }

        return new_id;
    }
}
