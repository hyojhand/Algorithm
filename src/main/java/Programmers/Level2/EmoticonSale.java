package Programmers.Level2;

// 2023 KAKAO BLIND RECRUITMENT - 이모티콘 할인행사
// 각 이모티콘은 10%, 20%, 30%, 40%의 4가지 할인율
// 1 ≤ users의 길이 = n ≤ 100
// 1 ≤ emoticons의 길이 = m ≤ 7
// O(n * m * 4^n) - 완전탐색시 시간복잡도
public class EmoticonSale {

    int maxMember = 0;
    int maxPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        // 구매한 금액 배열
        int[] buyPrice = new int[users.length];
        dfs(buyPrice, 0, users, emoticons);

        answer[0] = maxMember;
        answer[1] = maxPrice;
        return answer;
    }

    private void dfs(int[] buyPrice, int idx, int[][] users, int[] emoticons) {
        // 모든 이모티콘을 세일 후에 총합을 계산
        if (idx == emoticons.length) {
            getMaxAnswer(buyPrice, users);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            // idx 번째 이모티콘의 할인 퍼센트, 할인가격
            int percent = i * 10;
            int salePrice = emoticons[idx] * (100 - percent) / 100;

            // 구매가능한 할인율이라면 구매
            for (int j = 0; j < users.length; j++) {
                if (users[j][0] <= percent) {
                    buyPrice[j] += salePrice;
                }
            }

            // dfs 탐색
            dfs(buyPrice, idx + 1, users, emoticons);

            // 구매가능한 할인율이라 구매했다면 다시 복구
            for (int j = 0; j < users.length; j++) {
                if (users[j][0] <= percent) {
                    buyPrice[j] -= salePrice;
                }
            }
        }
    }

    private void getMaxAnswer(int[] buyPrice, int[][] users) {
        int joinCount = 0;
        int total = 0;
        // 구매비용 합이 기준을 넘었다면, 이모티콘 플러스 가입 / 그렇지 않다면 이모티콘 구매가격 총액 더하기
        for (int i = 0; i < users.length; i++) {
            if (buyPrice[i] >= users[i][1]) {
                joinCount++;
            } else {
                total += buyPrice[i];
            }
        }

        // 최대 이모티콘 플러스 가입자, 이모티콘 구매 총액 계산
        if (maxMember == joinCount) {
            maxPrice = Math.max(maxPrice, total);
        }
        if (maxMember < joinCount) {
            maxMember = joinCount;
            maxPrice = total;
        }
    }
}
