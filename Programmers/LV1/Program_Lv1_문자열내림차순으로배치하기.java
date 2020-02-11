import java.util.Arrays;

public class Program_Lv1_문자열내림차순으로배치하기 {

	public static void main(String[] args) {

		System.out.println(solution("bZcdefg"));
	}
	public static String solution(String s) {
		

		char[]p=s.toCharArray();
		Arrays.sort(p);
		StringBuilder sb=new StringBuilder();
		
		for(int j=p.length-1; j>=0; j--)
			sb.append(p[j]);
		
		
		return sb.toString();
	  }
}
