import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String s = "())";
        //   ([){}]      ([{}])   ([])

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '(' || currentChar == '[' || currentChar == '{'){
                stack.push(currentChar);
            } else {
                if(stack.isEmpty()){
                    System.out.println("false");
                    break;
                }
                char stackChar = stack.peek();
                if(currentChar == ')' && stackChar == '(' ||
                        currentChar == ']' && stackChar == '[' ||
                        currentChar == '}' && stackChar == '{'){
                    stack.pop();
                } else {
                    System.out.println("false!");
                    break;
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("true!");
        } else {
            System.out.println("false");
        }

    }
}
