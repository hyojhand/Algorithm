package Programmers.Level3;

// 선입 선출 스케줄링
// 코어의 수가 10000개, 처리하는 일의 개수는 50000개가 최대이므로, 각 시간마다 작업을 처리하면 시간초과가 발생한다.
// 시작시간과 최대 시간이 될 수 있는 n * 10000를 종료시간으로 이분탐색하여, 해당 시간에서 몇 개의 작업을 처리할 수 있는지 구한다.
// 각 코어에서 현재 시간을 나누기 연산하여 몇개의 작업이 처리가능한지 확인한다. 단, 0초에 모든 코어를 동시에 넣으므로 + 1을 수행해준다.
// 이분탐색을 하면서 원하는 n개보다 많은 작업을 수행할 때마다 해당 시간과 작업의 개수를 갱신해준다.
// 이후, n개만큼 뺀 값이 뒤에서 몇번째의 마지막 작업인지 확인해 해당 작업의 번호를 반환한다.
public class FifoScheduling {
    public int solution(int n, int[] cores) {
        int start = 0;
        int end = 10000 * n;

        int time = 0;
        int count = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int workCount = getWorkCount(mid, cores);

            if (workCount < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                time = mid;
                count = workCount;
            }
        }

        // 남은 처리해야하는 작업
        int remainCount = count - n;
        int answer = 0;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (remainCount == 0) {
                    answer = i + 1;
                    break;
                }
                remainCount--;
            }
        }

        return answer;
    }

    private int getWorkCount(int time, int[] cores) {
        int count = 0;
        for (int i = 0; i < cores.length; i++) {
            count += (time / cores[i]) + 1; // 0초에 모두 들어가는 개수 1 추가
        }
        return count;
    }
}
