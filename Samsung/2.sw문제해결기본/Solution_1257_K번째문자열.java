import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_1257_K번째문자열 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int tc=Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=tc; t++) {
			int find=Integer.parseInt(br.readLine());
			HashSet<String>hs=new HashSet<String>();
			String s=br.readLine();
			
			for (int i = 0; i < s.length()+1; i++) {
				for (int j = i+1; j < s.length()+1; j++) {
					String temp=s.substring(i, j);
					if(!hs.contains(temp))
						hs.add(temp);
				}
			}

			ArrayList<String> tmp=new ArrayList<String>();
			
			for(String a : hs)
				tmp.add(a);
			
			tmp.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
			String fin="";
			if(find>hs.size())
				fin="none";
			else
				fin=tmp.get(find-1);
			
			System.out.println("#"+t+" "+fin);

		}
	}
}
