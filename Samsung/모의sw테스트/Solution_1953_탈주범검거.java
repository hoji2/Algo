import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1953_탈주범검거 {

	static Scanner sc=new Scanner(System.in);
	static int row,col;
	static int[][]map;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
		
		int tc=sc.nextInt();
		for (int t = 1; t <=tc; t++) {
			row=sc.nextInt();
			col=sc.nextInt();
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			int time=sc.nextInt();
			map=new int[row][col];
			
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			if(time==1)
				System.out.println("#"+t+" "+1);
			else
				System.out.println("#"+t+" "+solve(sx,sy,time));
		}
	}
	
	public static int solve(int sx, int sy, int end_time) {
		Queue<point> tmp=new LinkedList<point>();
		boolean[][]visit=new boolean[row][col];
		int cur_time=1;
		tmp.add(new point(sx, sy));
		int debug=0;
		
		while(!tmp.isEmpty()) {
			if(cur_time>=end_time)
				break;
			
			int loop=tmp.size();
			
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				int nx=0;
				int ny=0;
				if(map[p.x][p.y]==1) {
					for (int j = 0; j < dir.length; j++) {
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==0) {
								if(next==1 || next==2 || next==5 || next==6 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else if(j==1) {
								if(next==1 || next==3 || next==4 || next==5) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else if(j==2) {
								if(next==1 || next==2 || next==4 || next==7 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else {
								if(next==3 || next==6 || next==1 || next==7) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else if(map[p.x][p.y]==2) {
					for (int j = 0; j < dir.length; j++) {
						if(j==1 || j==3) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==0) {
								if(next==1 || next==2 || next==5 || next==6 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==1 || next==2 || next==4 || next==7 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else if(map[p.x][p.y]==3) {
					for (int j = 0; j < dir.length; j++) {
						if(j==0 || j==2) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==1) {
								if(next==1 || next==3 || next==4 || next==5) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==3 || next==6 || next==1 || next==7) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else if(map[p.x][p.y]==4) {
					for (int j = 0; j < dir.length; j++) {
						if(j==1 || j==2) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==0) {
								if(next==1 || next==2 || next==5 || next==6 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==3 || next==6 || next==1 || next==7) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else if(map[p.x][p.y]==5) {
					for (int j = 0; j < dir.length; j++) {
						if(j==0 || j==1) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==2) {
								if(next==1 || next==2 || next==4 || next==7 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==3 || next==6 || next==1 || next==7) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else if(map[p.x][p.y]==6) {
					for (int j = 0; j < dir.length; j++) {
						if(j==0 || j==3) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==1) {
								if(next==1 || next==3 || next==4 || next==5) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==1 || next==2 || next==4 || next==7 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
				else {
					for (int j = 0; j < dir.length; j++) {
						if(j==2 || j==3) continue;
						nx=p.x+dir[j][0];
						ny=p.y+dir[j][1];
						if(nx>=0 && ny>=0 && nx<row && ny<col && map[nx][ny]!=0 && !visit[nx][ny]) {
							int next=map[nx][ny];
							if(j==0) {
								if(next==1 || next==2 || next==5 || next==6 ) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}else{
								if(next==1 || next==3 || next==4 || next==5) {
									visit[nx][ny]=true;
									tmp.add(new point(nx, ny));
									debug++;
								}
							}
						}
					}
				}
			}
			cur_time++;
		}
		
		return debug;
	}
}
class point{
	int x, y;
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}