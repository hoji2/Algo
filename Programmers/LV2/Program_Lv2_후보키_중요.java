import java.util.*;

public class Program_Lv2_후보키_중요 {

	// https://it-and-life.tistory.com/15
	// 순열 4c1~4c4 -> 비트연산자
	// StringFormat zeroPadding
	// 리스트 내에서 remove 연산 시 -> Iterator 사용
	public static void main(String[] args) {
		
		String[][]map= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		
		
		int bit_size=(int)Math.pow(2, map[0].length);
		
		PriorityQueue<Integer> tmp=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int c1=0,c2=0;
				String o3=String.format("%"+0+map[0].length+"d", Integer.parseInt(Integer.toBinaryString(o1).toString()));
				String o4=String.format("%"+0+map[0].length+"d", Integer.parseInt(Integer.toBinaryString(o2).toString()));
				for(char a : o3.toCharArray())
					if(a=='1')
						c1++;
				
				for(char a : o4.toCharArray())
					if(a=='1')
						c2++;
				
				return c1-c2;
			}
		});
		
		for(int i=1; i<=bit_size-1; i++) {
			if(check(i,map)==map.length) {
				tmp.add(i);
			}
		}
		
		int res=0;
		while(!tmp.isEmpty()) {
			int n=tmp.poll();
			res++;
			Iterator<Integer> it=tmp.iterator();
			
			while(it.hasNext()) {
				int q=it.next();
				if((n&q)==n) {
					it.remove();
				}
			}
		}
		
		System.out.println(res);
		
	}
	
	public static int check(int idx, String[][]map) {
		String s=String.format("%"+0+map[0].length+"d", Integer.parseInt(Integer.toBinaryString(idx).toString()));
		HashSet<String> hm=new HashSet<String>();
		
		for (int i = 0; i < map.length; i++) {
			StringBuilder sb=new StringBuilder();
			for (int j = 0; j < map[0].length; j++) {
				if(s.charAt(j)=='1')
					sb.append(map[i][j]);
			}
			
			if(!hm.contains(sb.toString()))
				hm.add(sb.toString());
		}
		
		return hm.size();
		
	}
}



