package Programmers.Kakao.Kakao2022;

import java.util.*;

// 2022 KAKAO BLIND RECRUITMENT - 신고 결과 받기
public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reportInfo = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportInfo.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }

        for (String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            String reporter = st.nextToken();
            String reported = st.nextToken();

            reportInfo.get(reported).add(reporter);
        }

        for (String s : id_list) {
            HashSet<String> send = reportInfo.get(s);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idx.get(name)]++;
                }
            }
        }

        return answer;
    }
}
