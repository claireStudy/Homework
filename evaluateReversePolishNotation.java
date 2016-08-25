public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        int result = 0, num = 0;
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        for (int i = 0; i < tokens.length; i++) {
            // if it is an operator
            if (set.contains(tokens[i])) {
                // pop two top numbers
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                // conduct the operation
                if (tokens[i].equals("+")) {
                    num = num1 + num2;
                } else if (tokens[i].equals("*")) {
                    num = num1 * num2;
                } else if (tokens[i].equals("-")) {
                    num = num2 - num1;
                } else if (tokens[i].equals("/")) {
                    num = num2 / num1;
                }
                // if it is the last number, return value. Else, push it onto the stack
                if (stack.isEmpty() && i == tokens.length - 1) {
                    return num;
                } else {
                    stack.push(Integer.toString(num));
                }
            } else {
                // if it is a number, just push it onto the stack
                stack.push(tokens[i]);
            }
            
        }
        return 0;
    }
}