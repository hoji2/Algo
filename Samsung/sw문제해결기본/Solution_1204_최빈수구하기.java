import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1204_최빈수구하기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		int tc=stoi(br.readLine());
		
		for (int i = 1; i <=tc; i++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
			
			while(st.hasMoreTokens()) {
				int tmp=stoi(st.nextToken());
				if(hm.containsKey(tmp))
					hm.put(tmp, hm.get(tmp)+1);
				else
					hm.put(tmp,1);
			}
			
			int cnt=0; int mid=0;
			
			for(int key : hm.keySet()) {
				int tmp=hm.get(key);
				if(tmp>cnt) {
					cnt=tmp;
					mid=key;
				}else if(tmp==cnt) {
					if(mid<key)
						mid=key;
				}
			}
			
			System.out.println("#"+i+" "+mid);
			
		}
		
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
