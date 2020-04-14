import java.util.HashSet;

public class Program_Lv2_소수찾기 {

	static boolean[]check=new boolean[10000000];
	static HashSet<Integer> tmp=new HashSet<Integer>();
	static char[]map,dp;
	static boolean[]visit;
	
	public static void main(String[] args) {

		String n="1276543";
		prime();
		
		map=n.toCharArray();
		dp=new char[n.length()];
		visit=new boolean[n.length()];
		for(int i=1; i<=n.length(); i++) {
			dfs(0,i);
		}
		
		System.out.println(tmp.size());
		
	}
	
	public static void dfs(int cnt, int max) {
		if(cnt==max) {
			int mid=0;
			int idx=1;
			for (int i = cnt-1; i >=0; i--) {
				mid+=(dp[i]-'0')*idx;
				idx*=10;
			}
			if(!check[mid] && !tmp.contains(mid))
				tmp.add(mid);
			
			return;
		}
		
		
		for (int i = 0; i < map.length; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dp[cnt++]=map[i];
				dfs(cnt, max);
				dp[--cnt]=0;
				visit[i]=false;
			}
		}
	}
	
	public static void prime() {
		check[1]=true;
		check[0]=true;
		for(int i=2; i<=9999999; i++) {
			if(!check[i]) {
				for(int j=i+i; j<=9999999; j+=i) {
					check[j]=true;
				}
			}
		}
	}
}
