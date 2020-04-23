import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		int size=Integer.parseInt(st.nextToken());
		int find=Integer.parseInt(st.nextToken());
		
		int[]arr=new int[size];
		st=new StringTokenizer(br.readLine());
		
		for (int i = 0; i < size; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		
		int left=0;
		int right=0;
		int sum=0;
		
		while(true) {
			
			if(sum>=find)
				sum-=arr[left++];
			else if(right==size)
				break;
			else
				sum+=arr[right++];
			
			if(sum==find)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
