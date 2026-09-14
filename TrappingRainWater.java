/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.

    example:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
    In  this case, 6 units of rain water (blue section) are being trapped.

    example:
    Input: height = [4,2,0,3,2,5]
    Output: 9 
 */


import java.util.*;
public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of bars: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.print("Enter the heights of the bars: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println("Trapped water: " + trap(height));
        sc.close();
    }
}
    