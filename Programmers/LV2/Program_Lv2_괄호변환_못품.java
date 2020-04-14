import java.util.Stack;

public class Program_Lv2_괄호변환_못품 {

	public static void main(String[] args) {
		
//		String s="()))((()";
		String s=")(";
		
		if(s.length()==0)
			System.out.println("");
		else
			System.out.println(dfs(s));
	}
	
	public static String dfs(String in) {
		
		int idx=valid(in);
		if(idx==-1)
			return in;
		
		if()
		
		return dfs(in.substring(0, idx))+dfs(in.substring(idx,in.length()));
		
	}
	
	// 체크와 동시에 좌표를 넘김
	public static int valid(String s) {
		
		Stack<Character> tmp=new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char p=s.charAt(i);
			if(p=='(')
				tmp.add(p);
			else {
				if(tmp.isEmpty())
					tmp.add(')');
				else if(tmp.peek()=='(')
					return i;
				else
					tmp.add(')');
			}
		}
		
		return -1;
		
	}
}
