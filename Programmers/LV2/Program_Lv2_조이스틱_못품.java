import java.util.LinkedList;
import java.util.Queue;

public class Program_Lv2_조이스틱_못품 {

	// AABAAAAAAABA 6 반례
	
	public static void main(String[] args) {

		String s="ABAAAAAAABA";
		
		StringBuilder sb=new StringBuilder(s);
		
		int res=0;
		
		for(int i=0; i<sb.length(); i++) {
			int q=sb.charAt(i)-'A';
			if(q>13)
				q=26-q;
			
			res+=q;
		}
		
		sb.replace(0, 1, "A");
		
		System.out.println(res+bfs(sb));
	}
	
	public static int bfs(StringBuilder sb) {
		Queue<point> tmp=new LinkedList<point>();
		
		int q=0;
		
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)!='A')
				q++;
		}
		
		tmp.add(new point(0, q));
		
		int time=0;
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				if(p.cnt==0)
					return time;
			
				
				int bx=p.x-1;
				int nx=p.x+1;
				if(bx<0)
					bx=sb.length()-1;
				if(nx>=sb.length())
					nx=0;
				
				if(sb.charAt(bx)!='A') {
					tmp.add(new point(bx, p.cnt-1));
				}else
					tmp.add(new point(bx, p.cnt));
				
				if(sb.charAt(nx)!='A') {
					tmp.add(new point(nx, p.cnt-1));
				}else
					tmp.add(new point(nx, p.cnt));
			}
			time++;
		}
		
		return 0;
	}
}

class point{
	int x, cnt;
	public point(int x, int cnt) {
		this.x=x;
		this.cnt=cnt;
	}
}
