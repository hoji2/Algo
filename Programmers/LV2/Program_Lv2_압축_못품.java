import java.util.*;

public class Program_Lv2_압축_못품 {

	public static void main(String[] args) {
		
		String msg="TOBEORNOTTOBEORTOBEORNOT";
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		HashMap<String, Integer> tmp=new HashMap<String, Integer>();
		
		for (int i = 65; i <=90; i++) {
			tmp.put((char)i+"", i-64);
		}
		
		StringBuilder sb=new StringBuilder(msg);
		boolean make=true;
		while(sb.length()!=0) {
			int idx=1;
			
			while(idx<sb.length()) {
				if(!tmp.containsKey(sb.substring(0, idx))) {
					make=false;
					break;
				}
				
				idx++;
			}
			
			res.add(tmp.get(sb.substring(0, idx-1)));
			if(make) {
				tmp.put(sb.substring(0,idx), tmp.size()+1);
			sb.delete(0, idx-1);
		}
		
		int[]fin=new int[res.size()];
		
		for (int i = 0; i < fin.length; i++)
			fin[i]=res.get(i);
		
		for(int i : fin)
			System.out.print(i+" ,");
			
	}
}
