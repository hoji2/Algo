import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1232_사칙연산 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static String[]text;
	static int[][]map;
	static int mid;
	public static void main(String[] args) throws IOException {
	
		for (int tc = 1; tc <=10; tc++) {
			
			int size=stoi(br.readLine());
			text=new String[size+1];
			map=new int[size+1][2];
			mid=0;
			
			for (int i = 0; i < size; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				// 입력이 복잡하므로 String으로 받자
				int idx=stoi(st.nextToken());
				String sec=st.nextToken();
				text[idx]=sec;
				
				if(sec.length()==1) {
					int tmp=0;
					while(st.hasMoreTokens())
						map[idx][tmp++]=stoi(st.nextToken());
				}
			}
			
			solve(1);
			System.out.println("#"+tc+" "+mid);
			
		}
	}
	
	public static void solve(int st) {

		// (중요) text[st]의 길이가 1인걸로 기호를 판별하려했으나 한자리 숫자인 경우에 에러가 발생함
		char p=text[st].charAt(0);
		// 기호가 아니면 부모로 돌아감
		if(!(p=='+' || p=='-' || p=='*' || p=='/'))
			return;
		// 기호면 자식이 있다
		int left=map[st][0];
		int right=map[st][1];
		
		if(left!=0 || right!=0) {
			solve(left);
			solve(right);
		}
		
		int left_value=stoi(text[map[st][0]]);
		int right_value=stoi(text[map[st][1]]);
		
		if(text[st].charAt(0)=='-') {
			mid=left_value-right_value;
		}else if(text[st].charAt(0)=='+') {
			mid=left_value+right_value;
		}else if(text[st].charAt(0)=='*') {
			mid=left_value*right_value;
		}else {
			mid=(int)(left_value/right_value);
		}
		text[st]=Integer.toString(mid);
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
