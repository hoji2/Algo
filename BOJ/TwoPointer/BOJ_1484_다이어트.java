import java.util.Scanner;

//https://baelanche.tistory.com/249
public class BOJ_1484_다이어트 {

	static Scanner sc=new Scanner(System.in);
	static final int max=100000;
	
	public static void main(String[] args) {
	
		int g=sc.nextInt();
		
		boolean exist=false;
		
		int cur=0,left=1,right=1;
		
		while(true) {

			cur=right*right-left*left;
			// 탈출조건 : left+1==right 이고 cur의 값이 g보다 크면 더이상 수행할 필요가 없음
			if(right-left==1 && cur>g)
				break;
			
			if(cur>=g)
				left++;
			else
				right++;
			
			if(cur==g) {
				exist=true;
				System.out.println(right);
			}
		}
        if(!exist)
            System.out.println(-1);
		
	}
}
