import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

////https://kuklife.tistory.com/22
public class BOJ_1305_광고 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int len=Integer.parseInt(br.readLine());
		char[]pattern=br.readLine().toCharArray();
		
		int[]table=makeTable(pattern);
		
		// len-table[len-1]
		System.out.println(len-table[len-1]);
	}
	
	private static int[] makeTable(char[]pattern) {
		
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
