package Programmers.Kakao.Kakao2023;

// 2023 KAKAO BLIND RECRUITMENT - 표현 가능한 이진트리
// 숫자를 이진법으로 변경하고, 해당 이진법의 길이보다 다음으로 큰 2의 제곱수의 길이를 구한다.
// 부족한 크기만큼 좌측을 0으로 채워준다. (이진법의 숫자 값이 변경되지 않기위해)
// 부모 노드가 0이라면, 자식노드도 무조건 0이 되는지 dfs로 탐색한다.
class FullBinaryTree {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        int idx = 0;
        for (long number : numbers) {

            // 숫자를 이진법으로 변환
            String binaryValue = Long.toBinaryString(number);

            // 포화 이진 트리를 위한 (총 노드 개수 - 변환한 이진법 길이) count
            int count = getCount(binaryValue);

            // 빈 갯수만큼 앞을 0으로 채워서 포화 이진 트리로 만든다.
            String fullTree = getFullTree(binaryValue, count);

            // 포화 이진 트리로 만들 수 있는지 확인
            boolean isMake = checkTree(fullTree);

            // 표현할 수 있다면 1
            if (isMake) {
                answer[idx] = 1;
            }

            idx++;
        }

        return answer;
    }

    private boolean checkTree(String tree) {
        int mid = tree.length() / 2;
        char root = tree.charAt(mid);
        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1);

        // root는 0인데, 자식노드가 1이라면 false
        if (root == '0' && (left.charAt(left.length() / 2) == '1' ||
                right.charAt(right.length() / 2) == '1')) {
            return false;
        }

        // root의 좌,우 중에 표현할 수 없는게 있다면 false
        if (left.length() >= 3) {
            return checkTree(left) && checkTree(right);
        }

        return true;
    }

    private String getFullTree(String value, int count) {
        while (count > 0) {
            value = "0" + value;
            count--;
        }

        return value;
    }

    private int getCount(String value) {
        int len = value.length();

        // 포화 이진 트리가 되기위한 총 노드 개수
        int totalLen = 0;
        int dept = 1;
        while (totalLen < len) {
            totalLen = (int) Math.pow(2, dept++) - 1;
        }

        return totalLen - len;
    }

}
