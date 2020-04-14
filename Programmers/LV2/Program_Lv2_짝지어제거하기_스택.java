import java.util.Stack;

public class Program_Lv2_짝지어제거하기_스택 {

  // https://lkhlkh23.tistory.com/148
  public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
         
        for(char c : s.toCharArray()) 
          if(!stack.isEmpty() && stack.peek() == c) stack.pop();
          else stack.push(c);
         
        return stack.isEmpty() ? 1 : 0;
    }
}
