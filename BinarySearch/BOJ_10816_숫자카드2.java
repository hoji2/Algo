import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();

		br.readLine();
		StringTokenizer st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int idx=stoi(st.nextToken());
			if(hm.containsKey(idx))
				hm.replace(idx, hm.get(idx)+1);
			else
				hm.put(idx, 1);
		}
		
		br.readLine();
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int idx=stoi(st.nextToken());
			if(hm.containsKey(idx))
				bw.write(hm.get(idx)+" ");
			else
				bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
