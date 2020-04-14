import java.util.Stack;

public class Program_Lv2_쇠막대기_중요_상황판단 {

	// https://developerdk.tistory.com/14
	// https://medium.com/@nsh235482/java-coding-programmers-stack-queue-lv2-%EC%87%A0%EB%A7%89%EB%8C%80%EA%B8%B0-d3c482da3d98
	public static void main(String[] args) {
		
		String s="()(((()())(())()))(())";
		
		Stack<Character> tmp=new Stack<Character>();
		
		int cnt=0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(')
				tmp.add('(');
			//레이저 경우
			else {
				tmp.pop();
				//레이저 앞에 있는 괄호가 '('이면 스택에 쌓인 개수
				if(s.charAt(i-1)=='(')
					cnt+=tmp.size();
				//레이저 앞에 괄호가 ')' 닫히는 가로이면 삐져나온 1개 카운팅
				else
					cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
