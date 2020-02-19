import java.util.Scanner;

public class BOJ_14889_스타트와링크 {

	static Scanner sc=new Scanner(System.in);
	static int n,res=Integer.MAX_VALUE;
	static int[][]map;
	static int[]fir,sec;
	static boolean[] visit;
	
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		fir=new int[n/2];
		sec=new int[n/2];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		// 중요 !! -> 순열이아니므로 뒤로 빽 할 필요가 없더 -> st 변수 사용
		solve(1,0);
		System.out.println(res);
	}
	
	public static void solve(int st, int cnt) {
		if(cnt==n/2) {
			
			int p=0;
			for (int i = 1; i <=n; i++) {
				boolean go=true;
				for (int j = 0; j < fir.length; j++) {
					if(fir[j]==i) {
						go=false;
						break;
					}
				}
				if(go)
					sec[p++]=i;
			}
			
			calc();
			return;
		}
		
		for (int i = st; i <=n; i++) {
			fir[cnt++]=i;
			solve(i+1,cnt);
			fir[--cnt]=0;
		}
	}
	
	public static void calc() {
		int v1=0, v2=0;
		
		//2개씩 짝지어서 뽑는 것
		int cnt=0;
		for (int i = 0; i < fir.length-1; i++) {
			for (int j = i+1; j < fir.length; j++) {
				int t1=fir[i];
				int t2=fir[j];
				v1+=map[t1][t2];
				v1+=map[t2][t1];
			}
		}
		
		for (int i = 0; i < sec.length-1; i++) {
			for (int j = i+1; j < sec.length; j++) {
				int t1=sec[i];
				int t2=sec[j];
				v2+=map[t1][t2];
				v2+=map[t2][t1];
			}
		}
		
		int tmp=Math.abs(v1-v2);
		res=Math.min(res, tmp);
	}
}
