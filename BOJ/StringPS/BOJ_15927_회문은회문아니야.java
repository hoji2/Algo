import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://degurii.tistory.com/39
public class BOJ_15927_회문은회문아니야 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[]dp;
	public static void main(String[] args) throws IOException {
	
		char[] s=br.readLine().toCharArray();
		
		boolean conse=true;
		for (int i = 0; i < s.length/2; i++) {
			// 전체문자열이 회문이아닌 경우 : 문자열 길이
			if(s[i]!=s[s.length-1-i]) {
				System.out.println(s.length);
				return;
			}
			// 처음==끝
			else {
				// 연속으로 같지 않은 경우 abbba
				if(s[i]!=s[i+1])
					conse=false;
			}
		}
		//aaaa
		if(conse)
			System.out.println(-1);
		//abbba -> 한글자만 빼면 회문이 아닌 최대 길이 문자열
		else
			System.out.println(s.length-1);
	}
}
