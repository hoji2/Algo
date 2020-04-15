import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_9280 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int park_size=Integer.parseInt(st.nextToken());
			int car_size=Integer.parseInt(st.nextToken());
			
			int[]park=new int[park_size+1];
			int[]parking=new int[park_size+1];
			int[]car=new int[car_size+1];
			
			for (int i = 1; i <=park_size; i++) {
				park[i]=Integer.parseInt(br.readLine());
			}
			
			for (int i = 1; i <=car_size; i++) {
				car[i]=Integer.parseInt(br.readLine());
			}
			
			int res=0;
			int parking_cnt=0;
			Queue<Integer> wait=new LinkedList<Integer>();
			
			for (int i = 0; i < car_size*2; i++) {
				int com=Integer.parseInt(br.readLine());
				if(com>0) {
					if(parking_cnt==park_size)
						wait.add(com);
					else {
						for (int j = 1; j <=park_size; j++) {
							if(parking[j]==0) {
								parking[j]=com;
								parking_cnt++;
								break;
							}
						}
					}
				}else {
					com*=-1;
					for (int j = 1; j <= park_size; j++) {
						if(parking[j]==com) {
							res+=car[com]*park[j];
							if(!wait.isEmpty())
								parking[j]=wait.poll();
							else {
								parking[j]=0;
								parking_cnt--;
							}
							break;
						}
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
