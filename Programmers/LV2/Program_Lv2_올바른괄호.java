import java.util.Stack;

public class Program_Lv2_올바른괄호 {

    boolean solution(String s) {
       
        Stack<Character>tmp= new Stack<Character>();
		
		if(s.charAt(0)==')')
			return false;
		
		tmp.add(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)=='(')
				tmp.add('(');
			else {
				// 스택에 pop이나 peek하기 전에 비어있는지 확인 중요!
                if(tmp.isEmpty())
                    return false;
                else{
                    if(tmp.peek()=='(')
					    tmp.pop();
				    else
					    return false;   
                }
			}
		}
		
		if(tmp.size()==0)
			return true;
		else
			return false;
		
    }
}
