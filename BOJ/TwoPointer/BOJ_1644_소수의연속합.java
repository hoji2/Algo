import java.util.Scanner;

public class BOJ_1644_소수의연속합 {

	static Scanner sc=new Scanner(System.in);
	static boolean[]visit;
	static final int size=4000000;
	static int prime_size;
	static int[]prime;
	
	public static void main(String[] args) {
	
		int find=sc.nextInt();
		init(find);
		
		int cnt=0, left=0, right=0, sum=0;
		
		while(true) {
			
			if(sum>=find) {
				sum-=prime[left++];
			}else if(right==prime_size)
				break;
			else {
				sum+=prime[right++];
			}
			
			if(sum==find)
				cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	private static void init(int find) {
		visit=new boolean[find+1];
		prime=new int[find+1];
		prime_size=0;
		
		for (int i = 2; i <=find; i++) {
			if(!visit[i]) {
				prime[prime_size++]=i;
				for (int j = i+i; j <=find; j+=i) {
					visit[j]=true;
				}
			}
		}
	}
}
