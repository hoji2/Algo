import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10951_A더하기B_4 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		while(true) {
			/* StringTocker로 한번에 받아 처리하는 경우 런타임에러
			Stringtocker st=new Stringtocker(br.readline)
			if(st==null)
			*/ 
			String s=br.readLine();
			if(s==null)
				return;
			else{
				StringTokenizer st=new StringTokenizer(s);
				System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
			}
		}
	}
}
