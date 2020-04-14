import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://hororolol.tistory.com/149
//https://baeharam.github.io/posts/algorithm/kmp/
public class BOJ_4354_문자열제곱 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		while(true) {
			String s=br.readLine();
			if(s.equals("."))
				return;
			
			int res=0;
			
			int[]table=makeTable(s.toCharArray());
			int len=s.length();
			int fail=len-table[len-1];
			
			//abcabcab -> 나누어 떨어지지 않으면 무조건 1
			if(len%fail!=0)
				System.out.println(1);
			else
				System.out.println(len/fail);
		}
	}
	
	private static int[] makeTable(char[] pattern) {
		
		int[]table=new int[pattern.length];
		
		int j=0;
		for (int i = 1; i < table.length; i++) {
			while(j>0 && pattern[i]!=pattern[j])
				j=table[j-1];
			
			if(pattern[i]==pattern[j])
				table[i]=++j;
		}
		
		return table;
		
	}
}
