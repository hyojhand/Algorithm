package Programmers.Kakao.Kakako2018;

import java.util.*;

// 2018 KAKAO BLIND RECRUITMENT - [3차] 파일명 정렬
// HEAD, NUMBER, TAIL을 분리해서 리스트에 저장한다.
// 이때, TAIL이 빈 문자열일 수 있기 때문에, number가 끝나는 인덱스 계산을 number start에서 size를 더해주는 방법을 선택했다.
// 기존에 for문을 break 하면서 바로 탈출하면 endIndex가 0이 되어 런타임 에러가 발생했다.
// 대문자로 통일한 HEAD를 먼저 정렬하고 같다면, 숫자로 정렬한다.
class FileNameSort {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (String fileValue : files) {
            // HAED, NUMBER, TAIL 분리
            fileList.add(getFileObject(fileValue));
        }

        Collections.sort(fileList, (o1, o2) -> {
            int headResult = o1.head.toUpperCase().compareTo((o2.head.toUpperCase()));

            // HEAD 정렬
            if (headResult > 0) {
                return 1;
            } else if (headResult < 0) {
                return -1;
            } else {
                // HEAD 같으면
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            }
        });

        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            answer[i] = file.head + file.number + file.tail;
        }

        return answer;
    }

    private File getFileObject(String value) {

        int startNumberIndex = 0;
        int endNumberIndex = 0;
        boolean firstNumber = true;
        int numberSize = 0;

        for (int i = 0; i < value.length(); i++) {

            // i번째 character가 숫자인지 확인
            if (Character.isDigit(value.charAt(i))) {
                // 첫번째 숫자라면
                if (firstNumber) {
                    startNumberIndex = i;
                    // 이후 숫자는 첫번째 숫자가 아님
                    firstNumber = false;
                }
                numberSize++;
            } else {
                // 숫자가 아닌데 첫번째 숫자도 지나갔다면 break
                if (!firstNumber) {
                    break;
                }
            }
        }

        // 마지막 숫자 인덱스는 start + numberSize (TAIL이 빈 문자열일 수도 있기 때문에)
        endNumberIndex = startNumberIndex + numberSize;

        String head = value.substring(0, startNumberIndex);
        String number = value.substring(startNumberIndex, endNumberIndex);
        String tail = value.substring(endNumberIndex);
        return new File(head, number, tail);
    }

    class File {
        String head, number, tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}
