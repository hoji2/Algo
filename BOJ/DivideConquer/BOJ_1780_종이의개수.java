import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	//https://developer-mac.tistory.com/38
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[]cnt=new int[3];
	static int[][]map;
	
	public static void main(String[] args) throws IOException {
	
		n=stoi(br.readLine());
		map=new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=stoi(st.nextToken());
			}
		}
		
		// row, col을 기준으로 divide, n
		divide(0,0,n);
		
		for (int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void divide(int row, int col, int n) {
		
		// 쪼개기 전 모두 같은 값인지 확인하
		if(check(row,col,n)) {
			cnt[map[row][col]+1]++;
		}
		// 아니면 쪼개기 작업
		// 현재 종이의 사이즈 n을 3으로 나누어 다음 종이 s로 정의
		// 3x3 반복문을 돌며 row와 col을 3단위씩 쪼개기, 종이의 사이즈도 s 
		else {
			int s=n/3;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//row=0, col=0, s=3인 경우
					//(0,0),(0,3),(0,6)
					//(3,0),(3,3),(3,6)
					//(6,0),(6,3),(6,6)
					divide(row+s*i,col+s*j,s);
				}
			}
		}
	}
	
	public static boolean check(int row, int col, int n) {
		int tmp=map[row][col];
		
		for (int i = row; i < row+n; i++) {
			for (int j = col; j < col+n; j++) {
				if(tmp!=map[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
