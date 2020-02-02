import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int n=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			char[]arr=br.readLine().toCharArray();
			solve(arr);
		}
	}
	
	public static void solve(char[]arr) {
		if(arr[0]==')' || arr[arr.length-1]=='(') {
			System.out.println("NO");
			return;
		}
		
		Stack<Character>tmp=new Stack<Character>();
		
		int idx=0;
		tmp.add(arr[idx++]);
		
		for (int j = 1; j < arr.length; j++) {
			if(tmp.isEmpty()) {
				tmp.add(arr[j]);
				continue;
			}
				
			char bef=tmp.peek();
			char cur=arr[j];
			
			if(bef=='(' && cur==')')
				tmp.pop();
			else
				tmp.add(cur);
		}
		
		if(tmp.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
			
	}
}
