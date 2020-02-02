import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int n=Integer.parseInt(br.readLine());
		ArrayList<info> tmp=new ArrayList<info>();
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
			
			String name=st.nextToken();
			int k=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			tmp.add(new info(name, k, e, m));
		}
		
		tmp.sort(new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				
				if(o1.k==o2.k) {
					if(o1.e==o2.e) {
						if(o1.m==o2.m)
							return o1.name.compareTo(o2.name);
						else
							return o2.m-o1.m;
					}else
						return o1.e-o2.e;
				}
				
				return o2.k-o1.k;
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(tmp.get(i).name);
		}
		
		
	}
}

class info{
	String name;
	int k,e,m;
	
	public info(String name, int k, int e, int m) {
		this.name=name;
		this.k=k;
		this.e=e;
		this.m=m;
	}
}
