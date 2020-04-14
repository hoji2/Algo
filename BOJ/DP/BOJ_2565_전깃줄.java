import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2565_전깃줄 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		point[]map=new point[n];
		int[]dp=new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i]=new point(sc.nextInt(), sc.nextInt());
			dp[i]=1;
		}
		
		Arrays.sort(map,new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				return o1.st-o2.st;
			}
		});
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < i; j++) {
				if(map[j].end<map[i].end)
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}
		
		Arrays.sort(dp);
		System.out.println(n-dp[n-1]);
	}
}

class point{
	int st,end;
	public point(int st, int end) {
		this.st=st;
		this.end=end;
	}
}