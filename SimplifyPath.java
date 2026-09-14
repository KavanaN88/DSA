import java.util.*;
public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue;
            }
            if(part.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(part);
            }
        }
        String result = "";
        for(String dir : stack) {
            result = result + "/" + dir;
        }
        return  result.isEmpty() ? "/" : result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path : ");
        String path = sc.nextLine();
        System.out.println("Output: " + simplifyPath(path));
        sc.close();
    }
}