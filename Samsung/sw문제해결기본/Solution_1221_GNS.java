import java.io.*;
import java.util.*;

public class Solution_1221_GNS {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static String[]arr= {"ZRO","ONE","TWO","THR","FOR","FIV","SIX","SVN","EGT","NIN"};
	static int[]cnt;
	public static void main(String[] args) throws IOException {
	
		int tc=Integer.parseInt(br.readLine());
		for (int T = 1; T <=tc; T++) {

			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			int size=Integer.parseInt(st.nextToken());
			
			String[]tmp=new String[size];
			st=new StringTokenizer(br.readLine());
			int idx=0;
			while(st.hasMoreTokens())
				tmp[idx++]=st.nextToken();
			
			Arrays.sort(tmp, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					
					int fir = 0, sec=0;
					
					for (int i = 0; i < arr.length; i++) {

						if(o1.equals(arr[i]))
							fir=i;
						
						if(o2.equals(arr[i]))
							sec=i;
					}
					return fir-sec;
				}
			});
			
			System.out.println("#"+T);
			for(String p : tmp) {
				bw.write(p+" ");
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
	
}
