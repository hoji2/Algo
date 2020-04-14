import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://jason9319.tistory.com/147
public class BOJ_10266_시계사진들 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static final int max=360000;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int len=Integer.parseInt(br.readLine());
		
		// 360000이라는 숫자를 하나의 문자열로 mapping 하기 위해 boolean의 idx로 사용
		boolean[]p1=new boolean[max*2];
		boolean[]p2=new boolean[max];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int a=Integer.parseInt(st.nextToken());
			p1[a]=true;
			p1[a+max]=true;
		}
		
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			p2[Integer.parseInt(st.nextToken())]=true;
					
		
		if(KMP(p1,p2))
			System.out.println("possible");
		else
			System.out.println("impossible");
	}
	
	private static boolean KMP(boolean[]text, boolean[]pattern) {
		
		int[]table=makeTable(pattern);
		//text 2배 작업
		
		int j=0;
		for (int i = 0; i < text.length; i++) {
			while(j>0 && text[i]!=pattern[j])
				j=table[j-1];
			
			if(text[i]==pattern[j]) {
				if(j==pattern.length-1)
					return true;
				else
					j++;
			}
		}
		
		return false;
	}
	
	private static int[] makeTable(boolean []pattern) {
		
		int[]table=new int[pattern.length];
		
		int j=0;
		for (int i = 1; i < pattern.length; i++) {
			while(j>0 && pattern[i]!=pattern[j])
				j=table[j-1];
			
			if(pattern[i]==pattern[j])
				table[i]=++j;
		}
		
		return table;
	}
}
