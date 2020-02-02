import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://dpdpwl.tistory.com/92
public class BOJ_11005_진법변환2 {

//	static Scanner sc=new Scanner(System.in);
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		long num=Long.parseLong(st.nextToken());
		int div=Integer.parseInt(st.nextToken());
		
		while(num/div!=0) {
			print((int)num%div);
			num/=div;
		}
		
		print((int)num);
		System.out.println(sb.reverse().toString());
	}
	
	public static void print(int num) {
		
		if(num>=10)
			sb.append((char) ('A'+num-10));
		else
			sb.append(num);
	}
}
