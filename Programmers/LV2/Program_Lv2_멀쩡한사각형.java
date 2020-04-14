
public class Program_Lv2_멀쩡한사각형 {

	//https://taesan94.tistory.com/55
	//https://lkhlkh23.tistory.com/154
	class Solution {
		public long solution(int w,int h) {
	        
	        long a=(long)w;
	        long b=(long)h;
	        long c=a*b;
	        long gcd=0;
	        
	        while(b>0){
	            gcd=b;
	            b=a%b;
	            a=gcd;
	        }
	        
			return c-(gcd*((long)w/gcd+(long)h/gcd-1));
		}
	}
}
