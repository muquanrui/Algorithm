package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 09/01/2022 11:56
 */
public class LeetCode0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        answer[answer.length - 1] = 0;
        for (int i = answer.length - 2; i > -1; i--) {
            int warmer = 1;
            while (temperatures[i + warmer] <= temperatures[i]) {
                if (answer[i + warmer] == 0) {
                    warmer = 0;
                    break;
                }
                warmer += answer[i + warmer];
            }
            answer[i] = warmer;
        }
        return answer;
    }
}
