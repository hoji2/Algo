import java.util.Scanner;

// https://spillmoon.tistory.com/176 참고

public class BOJ_1149_RGB거리 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[][] cost = new int[3][N];
    int r, g, b;
     
    cost[0][0] = scanner.nextInt();
    cost[1][0] = scanner.nextInt();
    cost[2][0] = scanner.nextInt();
     
    for(int i = 1; i < N; i++) {
      r = scanner.nextInt();
      g = scanner.nextInt();
      b = scanner.nextInt();
      
      /*
            앞 집에서 R을 선택하면 그 다음 집은 G 또는 B 중 작은 색	
	     앞 집에서 G를 선택하면 그 다음 집은 R 또는 B 중 작은 색
	     앞 집에서 B를 선택하면 그 다음 집은 R 또는 G 중 작은 색
      */
      cost[0][i] = r + Math.min(cost[1][i-1], cost[2][i-1]);
      cost[1][i] = g + Math.min(cost[0][i-1], cost[2][i-1]);
      cost[2][i] = b + Math.min(cost[0][i-1], cost[1][i-1]);
    }
    System.out.println(Math.min(cost[0][N-1], Math.min(cost[1][N-1], cost[2][N-1])));
    scanner.close();
  }
}

/*

<내코드>

import java.util.Scanner;

public class BOJ_1149_RGB거리 {

	static Scanner sc=new Scanner(System.in);
	// map배열과 같이 dp배열도 2차원으로 선언
	static int [][]map;
	static int [][]dp;
	
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		map=new int[n][3];
		dp=new int[n][3];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		dp[0][0]=map[0][0];
		dp[0][1]=map[0][1];
		dp[0][2]=map[0][2];
		
		solve(n);
		int res=Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			res=Math.min(res, dp[n-1][i]);
		}
		
		System.out.println(res);
	}
	
	public static void solve(int num) {
	
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < 3; j++) {
				int tmp=Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if(j==k) continue;
					//min값 판별 시 바로 윗단계 dp에 등록되어있는 값을 참조
					tmp=Math.min(tmp, dp[i-1][k]);
				}
				dp[i][j]=tmp+map[i][j];
			}
		}
	}
}
 
 
 */