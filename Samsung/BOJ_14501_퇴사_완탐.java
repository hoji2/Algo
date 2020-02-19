package samsung;
import java.util.Scanner;

public class BOJ_14501_퇴사_완탐 {

	static Scanner sc=new Scanner(System.in);
	static int n,res=0, mid=0;
	static meet[]map;
	public static void main(String[] args) {
	
		n=sc.nextInt();
		map=new meet[n+1];
		
		for (int i = 1; i <=n; i++) {
			map[i]=new meet(sc.nextInt(), sc.nextInt());
		}
		
		for (int i = 1; i <= n; i++) {
			mid=0;
			dfs(i,map[i].val,i+map[i].day);
			res=Math.max(res, mid);
		}
		
		System.out.println(res);
	}
	
	public static void dfs(int cur, int val, int next) {
		
		// 최종 n+1보다 넘어가면 무의미한값
		if(next>n+1) {
			return;
		}
		
		mid=Math.max(mid, val);
		
		for (int i = cur+1; i <=n; i++)
			// 다음 idx i 가 next보다 크거나 같아야함 
			if(i>=next)
				dfs(i,val+map[i].val,i+map[i].day);
		
	}
	
}


class meet{
	int day, val;
	
	public meet(int day, int val) {
		this.day=day;
		this.val=val;
	}
	
}
