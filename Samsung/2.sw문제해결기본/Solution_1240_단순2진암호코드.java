import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_단순2진암호코드 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static String[]map= {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	public static void main(String[] args) throws IOException {
	
		int tc=Integer.parseInt(br.readLine());
		for (int t = 1; t <=tc; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int loop=Integer.parseInt(st.nextToken());
			st.nextToken();
			String num="";
			for (int i = 0; i < loop; i++) {
				String tmp=br.readLine();
				if(tmp.contains("1"))
					num=tmp;
			}
			int last_idx=0;
			for (int i = 0; i < num.length(); i++) {
				if(num.charAt(i)=='1')
					last_idx=i;
			}
			
			num=num.substring(last_idx-56+1, last_idx+1);
			int[]arr=new int[8];
			
			for (int i = 0; i < 8; i++) {
				String check=num.substring(i*7,i*7+7);
				for (int j = 0; j < map.length; j++) {
					if(map[j].equals(check)) {
						arr[i]=j;
						break;
					}
				}
			}
			
			int odd=0,even=0;
			int last=arr[7];
			for (int i = 0; i <=6; i++) {
				if(i%2==0)
					odd+=arr[i];
				else
					even+=arr[i];
			}
			int res=0;
			if((odd*3+even+last)%10==0)
				res=odd+even+last;
		
			System.out.println("#"+t+" "+res);
		}
	}
}
