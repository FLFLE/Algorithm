package leetcode;

/**
 * @author zengfanyu
 * @date 2020/11/1 16:36
 */
public class SpiralOrder {
    public int[] solution(int[][] matrix) {
        int[] solution = new int[matrix.length * matrix[0].length];
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int index = 0;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                solution[index++] = matrix[top][i];
            }
            for (int i = top; i < bottom; i++) {
                solution[index++] = matrix[i][right];
            }
            for (int i = right; i > left; i--) {
                solution[index++] = matrix[bottom][i];
            }
            for (int i = bottom; i > top; i--) {
                solution[index++] = matrix[i][left];
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if(top == bottom) {
            for(int i = left; i <= right; i++) {
                solution[index++] = matrix[top][i];
            }
        }
        else if(left == right) {
            for(int i = top; i <= bottom; i++) {
                solution[index++] = matrix[i][left];
            }
        }
        return solution;
    }
}
