
public class Program_Lv2_카펫 {

	public static void main(String[] args) {
		
		//가로 >= 세로
		// (row+2)*(col+2)==tot -> 직접 그려보기
		// red의 약수개수의 반만큼 완탐
		int brown=10;
		int red=2;
		int tot=brown+red;
		int []res=new int[2];
		
		int loop=(int)Math.sqrt(red);
		
		for(int i=1; i<=loop; i++) {
			if(red%i==0) {
				int row=i;
				int col=red/i;
				if((row+2)*(col+2)==tot) {
					res[0]=col+2;
					res[1]=row+2;
					break;
				}
			}
		}
		
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
