
public class Program_Lv2_타겟넘버 {

	static int res=0;
	static boolean[]visit;
	public static void main(String[] args) {
	
		int[]map= {1,1,1,1,1};
		int t=3;
		
		visit=new boolean[map.length];
		
		dfs(0,0,0,map,t);
		System.out.println(res);
	}
	
	public static void dfs(int sum, int idx, int cnt, int[]map, int t) {
		
		if(cnt==map.length) {
			if(sum==t)
				res++;
			
			return;
		}
		
		dfs(sum+map[idx],idx+1,cnt+1,map,t);
		dfs(sum-map[idx],idx+1,cnt+1,map,t);
	
	}
}
