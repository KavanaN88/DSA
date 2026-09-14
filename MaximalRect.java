/*
    Given a rows * cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area
    
    Example1:
    Input: matrix = [["1", "0", "1", "0", "0"],
                     ["1", "0", "1", "1", "1"],
                     ["1", "1", "1", "1", "1"],
                     ["1", "0", "0", "1", "0"],
    output: 6
    
    Example2:
    Input: matrix = [["0"]]
    output: 0
    
    Example3:
    Input: matrix = [["1"]]
    output: 1
*/

import java.util.*;
public class MaximalRect {
    //Find the largest rectangle in histogram
    public static int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++) {
            int currentHeight;
            if(i == heights.length) {
                currentHeight = 0;
            }else{
                currentHeight = heights[i];
            }
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) {
                    width = i;
                }else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
    //Main function
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int max = 0;
        //Go row by row
        for(int i=0; i<rows; i++) {
            //create histogram
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == '1') {
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            //Find the largest rectangle in this histogram
            int area = largestRectangle(heights);
            max = Math.max(max, area);
        }
        return max;
    }
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximum Area = " + maximalRectangle(matrix));
    }
}