import java.util.Scanner;

public class Solution_1952_수영장 {

	static Scanner sc=new Scanner(System.in);
	static int[]cost;
	static int[]month;
	static int res;
	public static void main(String[] args) {

		int tc=sc.nextInt();
		
		for (int t = 1; t <=tc; t++) {
			cost=new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i]=sc.nextInt();
			}
			
			month=new int[13];
			for (int i = 1; i <=12; i++) {
				month[i]=sc.nextInt();
			}
			//연간을 넣어놈
			res=cost[3];
			solve(1,0);
			System.out.println("#"+t+" "+res);
		}
	}
	
	public static void solve(int cur_month, int cur_cost) {
		if(cur_month>=13) {
			res=Math.min(res, cur_cost);
			return;
		}
		
		if(month[cur_month]==0)
			solve(cur_month+1,cur_cost);
		else {
			//day
			solve(cur_month+1,cur_cost+month[cur_month]*cost[0]);
			//1달
			solve(cur_month+1,cur_cost+cost[1]);
			//3달
			solve(cur_month+3,cur_cost+cost[2]);
		}
	}
}
