/*
    Given an array of integers heights representing the histogram's bar heights where the width of each bar is 1, return the area of the
    largest rectangle in the histogram.
    
    Example 1:
    Input: heights = [2, 1, 5, 6, 2, 3]
    Output: 10
    
    Input: heights = [2, 4]
    Output: 4 */

import java.util.*;
public class LargestRect {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++) {
            int currentHeight;
            //At the end, use 0 to empty the stack
            if(i == heights.length) {
                currentHeight = 0;
            }else{
                currentHeight = heights[i];
            }
            //If current bar is smaller, calculate area 
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bars : ");
        int n = sc.nextInt();
        int[] heights = new int[n];
        System.out.println("Enter heights");
        for(int i=0; i<n; i++){
            heights[i] = sc.nextInt();
        }
        int answer = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area = " + answer);
        sc.close();
    }
}