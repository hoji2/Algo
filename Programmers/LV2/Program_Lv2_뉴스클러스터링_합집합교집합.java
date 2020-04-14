import java.util.HashMap;

public class Program_Lv2_뉴스클러스터링_합집합교집합 {

	// 굳이 hashMap을 사용할필요가 없다
	// 중복데이터를 모두 받아 ArrayList로 해결하는 방법
	//https://codedrive.tistory.com/235
	public static void main(String[] args) {
		
		String s1="aa1+aa2";
		String s2="AAAA12";
		
		s1=s1.toUpperCase();
		s2=s2.toUpperCase();
		
		HashMap<String, Integer>hm1=new HashMap<String, Integer>();
		HashMap<String, Integer>hm2=new HashMap<String, Integer>();
		
		for (int i = 0; i < s1.length()-1; i++) {
			char a=s1.charAt(i);
			char b=s1.charAt(i+1);
			
			if(a>=65 && a<=90 && b>=65 && b<=90) {
				String p=a+""+b+"";
				if(hm1.containsKey(p))
					hm1.put(p, hm1.get(p)+1);
				else
					hm1.put(p, 1);
			}
		}
		
		for (int i = 0; i < s2.length()-1; i++) {
			char a=s2.charAt(i);
			char b=s2.charAt(i+1);
			
			if(a>=65 && a<=90 && b>=65 && b<=90) {
				String p=a+""+b+"";
				if(hm2.containsKey(p))
					hm2.put(p, hm2.get(p)+1);
				else
					hm2.put(p, 1);
			}
		}
		
		// 교집합 son, 합집합 전체(A+B)-교집합(son)
		if(hm1.size()==0 && hm2.size()==0)
			System.out.println(65536);
		else {
			double mom=0;
			double son=0;
			
			for(String p : hm1.keySet()) {
				mom+=hm1.get(p);
				if(hm2.containsKey(p)) {
					int fir=hm1.get(p);
					int sec=hm2.get(p);
					son+=Math.min(fir, sec);
				}
			}
			
			for(String p : hm2.keySet())
				mom+=hm2.get(p);
			
			
			System.out.println((int)(son/(mom-son)*65536));
		}
	}
}
