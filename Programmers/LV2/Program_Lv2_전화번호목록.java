import java.util.HashSet;

public class Program_Lv2_전화번호목록 {

	// 중복의 경우 문제 -> 자료구조 해시 고려해보기
	public static void main(String[] args) {

		String[]map= {"119", "97674223", "1195524421"};
		HashSet<String> tmp=new HashSet<String>();
		
		boolean fin=true;
		for(String p : map) {
			if(tmp.contains(p)) {
				fin=false;
				break;
			}else
				tmp.add(p);
		}
		
		boolean find=false;
		
		if(fin==false)
			System.out.println(fin);
		else {
			for(String q : tmp) {
				if(!find)
					for(String p : map) {
						if(q.equals(p)) continue;
						int len=q.length();
						if(len>p.length()) continue;
						
						if(p.substring(0, len).equals(q)) {
							find=true;
							fin=false;
							break;
						}
						
					}
			}
			System.out.println(fin);
		}
	}
}
