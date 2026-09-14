/*
    Given a string a containing just the characters '(', ')', '{', '}', '[', ']', determine if the input string is valid.
    Example 1: 
    input: s = "()"
    output: True
    
    Example 2: 
    input: s = "([])"
    output: True
    
    Example 3: 
    input: s = "() [] {}"
    output: True

    Example 4: 
    input: s = "(]"
    output: False 
    
    Example 5: 
    input: s = "([)]"
    output: False*/


import java.util.Scanner;
import java.util.Stack;
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            }
            else if(ch == '{') {
                stack.push('}');
            }
            else if(ch == '['){
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the brackets: ");
        String s = sc.nextLine();
        System.out.println("Output : " + isValid(s));
        sc.close();
    }
}
