import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution_1256_k번째접미어 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			int find=Integer.parseInt(br.readLine());
			String s=br.readLine();
			
			ArrayList<String> tmp=new ArrayList<String>();
			int idx=0;
			while(idx!=s.length())
				tmp.add(s.substring(idx++));
			
			tmp.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
			String fin="";
			if(find>s.length())
				fin="none";
			else
				fin=tmp.get(find-1);
			
			System.out.println("#"+t+" "+fin);
		}
	}
}
