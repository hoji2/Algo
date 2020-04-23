import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int size=Integer.parseInt(st.nextToken());
		int find=Integer.parseInt(st.nextToken());
		
		int[]map=new int[size];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		boolean exist=false;
		int min=Integer.MAX_VALUE, left=0, right=0, sum=0;
		
		while(true) {
			
			if(sum>=find) {
				sum-=map[left++];
			}else if(right==size)
				break;
			else
				sum+=map[right++];
			
			if(sum>=find) {
				exist=true;
				int mid=right-left;
				min=Math.min(min, mid);
			}
		}
		
		if(!exist)
			min=0;
		
		System.out.println(min);
			
	}
}
