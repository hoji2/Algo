import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb=new StringBuffer();
	static char[][]map;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		n=Integer.parseInt(br.readLine());
		map=new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		divide(0,0,n);
		
		//애초에 하나로 압축가능한 경우 그냥 숫자만 출력
		/*
		 예를들어
		 2
		 11
		 11
		 -> 1
		 */
		System.out.println(sb);
	}
	
	public static void divide(int row, int col, int size) {
		//현재 divide된 영역이 하나로 압축가능한 경우
		if(check(row,col,size))
			sb.append(map[row][col]);
		else {
			// 압축의 구간을 표시하는 ()append
			sb.append("(");
			int p=size/2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(row+i*p,col+j*p,p);
				}
			}
			sb.append(")");
		}
	}
	
	public static boolean check(int row, int col, int n) {
		char tmp=map[row][col];
		for (int i = row; i < row+n; i++) {
			for (int j = col; j < col+n; j++) {
				if(map[i][j]!=tmp)
					return false;
			}
		}
		
		return true;
	}
}
