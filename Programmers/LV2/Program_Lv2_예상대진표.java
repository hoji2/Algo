
public class Program_Lv2_예상대진표 {

	public static void main(String[] args) {
		
		int n=8;
		int a=4;
		int b=6;
				
		int res=1;
		
		while(true) {
			if(Math.abs(a-b)==1 && a/2!=b/2 && a%2!=b%2) {
				break;
			}
			
			if(a%2==0)
				a/=2;
			else
				a=a/2+1;
			if(b%2==0)
				b/=2;
			else
				b=b/2+1;
			
			res++;
		}
		
		System.out.println(res);
		
		
	}
}
