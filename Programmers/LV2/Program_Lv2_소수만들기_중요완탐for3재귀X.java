
public class Program_Lv2_소수만들기_중요완탐for3재귀X {

	static boolean[]dp=new boolean[3001];
	public static void main(String[] args) {
		
		int[] nums= {1,2,3,4};
		
		prime();
		
		int res=0;
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(!dp[nums[i]+nums[j]+nums[k]])
						res++;
				}
			}
		}
		System.out.println(res);
	}
	
	static void prime() {
		
		for (int i = 2; i <=3000; i++) {
			if(!dp[i]) {
				for (int j = i+i; j <=3000; j+=i) {
					dp[j]=true;
				}
			}
		}
	}
}
