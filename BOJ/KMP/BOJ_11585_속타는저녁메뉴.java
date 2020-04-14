import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://jech-jose.tistory.com/67
public class BOJ_11585_속타는저녁메뉴 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int len=Integer.parseInt(br.readLine());
		
		char[]pattern=br.readLine().trim().replace(" ", "").toCharArray();
		char[]mid=br.readLine().trim().replace(" ", "").toCharArray();
		
		char[]text=new char[mid.length*2-1];
		
		for (int i = 0; i < text.length; i++) {
			text[i]=mid[i%mid.length];
		}
		
		int res=KMP(text,pattern);
		divide(res,len);

	}
	
	private static int KMP(char[]text, char[]pattern) {
		
		int res=0;
		int[]table=makeTable(pattern);
		
		int j=0;
		for (int i = 0; i < text.length; i++) {
			while(j>0 && text[i]!=pattern[j])
				j=table[j-1];
			
			if(text[i]==pattern[j]) {
				if(j==pattern.length-1) {
					res++;
					j=table[j];
				}else {
					j++;
				}
			}
		}
		
		return res;
		
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
	
	private static void divide(int son, int mom) {
		
		int a=son;
		int b=mom;
		int c=son*mom;
		
		int gcd=0;
		
		while(b>0) {
			gcd=b;
			b=a%b;
			a=gcd;
		}
		
		son/=gcd;
		mom/=gcd;
		
		System.out.println(son+"/"+mom);
		
	}
}
