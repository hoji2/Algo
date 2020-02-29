import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2621_카드게임 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		// 카드 색깔
		HashMap<Character, Integer> col=new HashMap<Character, Integer>();
		HashMap<Integer, Integer> num=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			char a=st.nextToken().charAt(0);
			int b=Integer.parseInt(st.nextToken());
			
			if(col.containsKey(a))
				col.put(a, col.get(a)+1);
			else
				col.put(a, 1);

			if(num.containsKey(b))
				num.put(b, num.get(b)+1);
			else
				num.put(b, 1);
		}
		
		int res=0;
		
		int []tmp=new int[num.size()];
		int idx=0;
		for(int i : num.keySet()) {
			tmp[idx++]=i;
		}
		Arrays.sort(tmp);
		
		if(col.size()==1) {
			// 5개의 숫자가 연속인 경우
			if(tmp.length==5) {
				boolean con=true;
				for (int i = 0; i < 4; i++) {
					if(tmp[i+1]-tmp[i]!=1){
						con=false;
						break;
					}
				}
				if(con) {
					res=900+tmp[tmp.length-1];
				}else {
					res=600+tmp[tmp.length-1];
				}
			}else {
				res=600+tmp[tmp.length-1];
			}
		}else {
			// 숫자 2개(1-4 or 2-3)
			if(num.size()==2) {
				int fir=num.get(tmp[0]);
				// (4,1), (1,4) ,(2,3) , (3,2) 경우의수 나누기
				if(fir==4)
					res=800+tmp[0];
				else if(fir==1)
					res=800+tmp[1];
				else if(fir==2)
					res=(tmp[1]*10+tmp[0])+700;
				else
					res=(tmp[0]*10+tmp[1])+700;
			}
			// 숫자 3개
			else if(num.size()==3) {
				
				int one=-1;
				int max_two=-1;
				int three=-1;
				
				for (int i = 0; i < tmp.length; i++) {
					if(num.get(tmp[i])==3) {
						three=tmp[i];
						break;
					}else if(num.get(tmp[i])==1) {
						one=i;
					}else
						max_two=i;
				}
				
				// 2, 2 ,1 인경우
				if(three==-1) {
					int min_two=-1;
					
					for (int i = 0; i < 3; i++) {
						if(num.get(tmp[i])==2 && i!=max_two) {
							min_two=i;
							break;
						}
					}
					res=(10*tmp[max_two]+tmp[min_two])+300;
				}
				// 3,1,1인경우
				else {
					res=400+three;
				}
			}
			//숫자 4개
			else if(num.size()==4) {
				for (int i = 0; i < tmp.length; i++) {
					if(num.get(tmp[i])==2) {
						res+=200+tmp[i];
						break;
					}
				}
			}
			//숫자 5개
			else if(num.size()==5){
				// 5개의 숫자 가 연속인경우
				boolean con=true;
				for (int i = 0; i < 4; i++) {
					if(tmp[i+1]-tmp[i]!=1){
						con=false;
						break;
					}
				}
				if(con) {
					res=500+tmp[tmp.length-1];
				}else {
					res=100+tmp[tmp.length-1];
				}
			}
			// 숫자 1개
			else {
				res=100+tmp[tmp.length-1];
			}
		}
		System.out.println(res);
	}
}
