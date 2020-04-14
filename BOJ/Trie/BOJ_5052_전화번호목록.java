import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_5052_전화번호목록 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			int size=Integer.parseInt(br.readLine());
			
			String[]s=new String[size];
			for (int i = 0; i < s.length; i++) {
				s[i]=br.readLine();
			}
			
			Arrays.sort(s,new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			
			boolean ans=valid(s);
			if(!ans)
				System.out.println("NO");
			else
				System.out.println("YES");
			
		}
	}
	
	// 정렬된 상태이기에 인접한 문자열 끼리만 비교하면 됨!
	private static boolean valid(String[]s) {
		
		for (int i = 0; i < s.length-1; i++) {
			char[]c1=s[i].toCharArray();
			char[]c2=s[i+1].toCharArray();
			boolean pass=false;
			for (int j = 0; j < c1.length; j++) {
				if(c1[j]!=c2[j]) {
					pass=true;
					break;
				}
			}
			if(!pass)
				return false;
		}
		
		return true;
	}
}
