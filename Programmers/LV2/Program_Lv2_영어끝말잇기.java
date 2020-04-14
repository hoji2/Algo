import java.util.HashSet;

public class Program_Lv2_영어끝말잇기 {

	public static void main(String[] args) {
		
		int n=3;
		String[]map= {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		String[]map= {"hello", "one", "even", "never", "now", "world", "draw"};
		
		int[]res=new int[2];
		
		int idx=0;
		
		HashSet<String> tmp=new HashSet<String>();
		
		tmp.add(map[0]);
		String before=map[0];
		for (int i = 1; i < map.length; i++) {
		
			if(before.charAt(before.length()-1)==map[i].charAt(0)) {
				if(tmp.contains(map[i])) {
					idx=i;
					break;
				}else {
					tmp.add(map[i]);
					before=map[i];
				}
			}else {
				idx=i;
				break;
			}
		}
		
		if(idx!=0){
            res[0]=idx%n+1;
		    res[1]=idx/n+1;    
        }
		
		System.out.println(res[0]+" "+res[1]);
		
	}
}
