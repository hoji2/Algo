
public class Program_Lv2_단체사진찍기 {
	
	// 8(자리찾기)*8!(경우의수)*100판별
	static char[]map= {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static char[]dp=new char[8];
	static boolean[]visit=new boolean[8];
	static int res;
	
	public static void main(String[] args) {
		
		res=0;
		int n=2;
		String[]data= {"N~F=0", "R~T>2"};
		
		dfs(0,data);
		System.out.println(res);
	}
	
	public static void dfs(int cnt, String[]data) {
		
		if(cnt==8) {
			
			for (int i = 0; i < data.length; i++) {
				
				char st=data[i].charAt(0);
				char end=data[i].charAt(2);
				char p=data[i].charAt(3);
				
				int st2=0, end2=0;
				int len=data[i].charAt(4)-'0';
				
				// 중요! 이 로직 해쉬로 짜는 게 더 효율적
				for (int j = 0; j < 8; j++) {
					if(dp[j]==st) {
						st2=j;
						break;
					}
				}
				
				for (int j = 0; j < 8; j++) {
					if(dp[j]==end) {
						end2=j;
						break;
					}
				}
				
				if(p=='=' && Math.abs(st2-end2)-1!=len)
					return;
				else if(p=='>' && Math.abs(st2-end2)-1<=len)
					return;
				else if(p=='<' && Math.abs(st2-end2)-1>=len)
					return;
				
			}
			res++;
			return;
		}
		
		for (int i = 0; i < dp.length; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dp[cnt]=map[i];
				dfs(cnt+1, data);
				visit[i]=false;
			}
		}
	}

}
