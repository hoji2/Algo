
public class Program_Lv2_카카오프렌즈컬러링북 {

	class Solution {
	    
		  static boolean[][]visit;
		  static int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
		  static int res;
		  
		  public int[] solution(int m, int n, int[][] map) {
		      int cnt=0;
		      int max=Integer.MIN_VALUE;
		      visit=new boolean[m][n];
		      
		      for(int i=0; i<m; i++){
		          for(int j=0; j<n; j++){
		              if(map[i][j]!=0 && !visit[i][j]){
		                  cnt++;
		                  res=0;
		                  dfs(i,j,m,n,map,map[i][j]);
		                  max=Math.max(max,res);
		              }
		          }
		      }
		      int[]fin=new int[2];
		      fin[0]=cnt;
		      fin[1]=max;
		      return fin;
		    
		  }
		    
		    public void dfs(int r, int c, int m, int n, int[][]map, int p){
		        if(map[r][c]!=p)
		            return;
		        
		        for(int i=0; i<dir.length; i++){
		            int nx=r+dir[i][0];
		            int ny=c+dir[i][1];
		            if(nx>=0 && ny>=0 && nx<m && ny<n && !visit[nx][ny] &&map[nx][ny]==p){
		                visit[nx][ny]=true;
		                res++;
		                dfs(nx,ny,m,n,map,p);
		            }
		        }
		    }
		}
}
