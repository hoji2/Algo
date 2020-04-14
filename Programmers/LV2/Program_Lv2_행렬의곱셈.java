
public class Program_Lv2_행렬의곱셈 {

	public static void main(String[] args) {
		
		int[][] arr1={{2,3,2},{4,2,4},{3,1,4}};
		int[][] arr2={{5,4,3},{2,4,1},{3,1,1}};
		
		int row=arr1.length;
		int col=arr2[0].length;
		
		
		int[][]res=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// row 한줄
				int []tmp1=arr1[i];
				for (int k = 0; k < tmp1.length; k++) {
					// col 하나씩 뽑아서 k idx를 변화시키며 곱셈
					int tmp2=arr2[k][j];
					res[i][j]+=tmp1[k]*tmp2;
				}
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(res[i][j]+" ");
			}System.out.println();
		}
	}
}
