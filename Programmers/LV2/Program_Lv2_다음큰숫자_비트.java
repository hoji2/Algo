
public class Program_Lv2_다음큰숫자_비트 {

	// https://shoark7.github.io/programming/knowledge/some-useful-bit-tricks-and-usages
	public static void main(String[] args) {

		int n=7;

		String s=Integer.toBinaryString(n);
		// n=7 -> 111일 때는 다음 자리수 까지 고려해야함
		int end=(1<<s.length()+1)-1;
		int cnt=convert(n);
		
		int res=0;
		
		for (int i = n+1; i <=end; i++) {
			if(cnt==convert(i)) {
				res=i;
				break;
			}
		}
		
		System.out.println(res);
	}
	
	public static int convert(int n) {
		
		int k=0;
		int cnt=0;
		
		while(n>=(1<<k)) {
			if((n & (1<<k))!=0)
				cnt++;
			k++;
		}
		return cnt;
	}
}
