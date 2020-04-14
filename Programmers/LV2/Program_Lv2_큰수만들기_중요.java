
public class Program_Lv2_큰수만들기_중요 {

	// 가장 앞에있는 수를 최대로 만드는 greedy
	public static void main(String[] args) {
		
		String s="778787766";
		int k=4;
		
		StringBuilder sb=new StringBuilder(s);
		
		int idx=0;
		// 범위가 넘어가면 끝
		while(idx+1<sb.length()) {
			// 그 와중에 cnt가 0이되면 그만
			if(k==0)
				break;
			
			// 다음숫자가 작은경우 cnt(k)감소하고 idx=0초기화
			if(sb.charAt(idx)<sb.charAt(idx+1)) {
				sb.deleteCharAt(idx);
				k--;
				idx=0;
			}else
				idx++;
		}
		
		// 맨앞이 큰수인 수로 만든 후에도 삭제할 카운트 k가남아있으면 맨뒤에서 부터 삭제
		for (int i = 0; i < k; i++) 
			sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb.toString());
		
	}
}
