import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {

	static Scanner sc=new Scanner(System.in);
	static ArrayList<spot> home=new ArrayList<spot>();
	static ArrayList<spot> chicken=new ArrayList<spot>();
	static int[]dp;
	static int size, sel, res=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
	
		size=sc.nextInt();
		sel=sc.nextInt();
		dp=new int[sel];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				int tmp=sc.nextInt();
				if(tmp==1)
					home.add(new spot(i, j));
				else if(tmp==2)
					chicken.add(new spot(i, j));
			}
		}
		
		for (int i = 1; i <= sel; i++) {
			solve(0,0,i);
		}
		System.out.println(res);
	}
	
	public static void solve(int st, int cnt, int max) {
		
		if(cnt==max) {
			calc(cnt);
			return;
		}
		
		for (int i = st; i <chicken.size(); i++) {
			dp[cnt++]=i;
			solve(i+1, cnt, max);
			dp[--cnt]=-1;
		}
	}
	
	public static void calc(int cnt) {
		

		int tmp=0;
		for(spot hm : home) {
			
			int dis=Integer.MAX_VALUE;
			for (int i = 0; i < cnt; i++) {
				spot ch=chicken.get(dp[i]);
				dis=Math.min(dis, Math.abs(ch.x-hm.x)+Math.abs(ch.y-hm.y));
			}
			tmp+=dis;
		}
		
		res=Math.min(res, tmp);
	}
}

class spot{
	int x,y;
	public spot(int x, int y) {
		this.x=x;
		this.y=y;
	}
}