/*
    Given a string containing just the characters '('and')', return the length of the longest valid (well-formed) parentheses 
    substring.
    Example 1:
    Input: s = "(()"
    output: 2
    Explanation: The longest valid parentheses substring is "()".   
    
    Example 2:
    Input: s = ")()())"
    output: 4
    
    Example 3:
    Input: s = ""
    output: 0
*/



import java.util.*;


public class LongestParentheses {

    public static int LongestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    int length = i - stack.peek();   //length = current index - previous boundary
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the brackets: ");
        String s = sc.nextLine();
        System.out.println("Output : " + LongestValidParentheses(s));
        sc.close();
    }
}