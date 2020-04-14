import java.util.HashSet;

public class Program_Lv2_폰켓몬 {

	public static void main(String[] args) {
		
		int[]num= {1,1,1,1,2,2};
		
		int size=num.length/2;
		
		HashSet<Integer> tmp=new HashSet<Integer>();
		for(int i : num)
			tmp.add(i);
		
		if(tmp.size()>=size)
			System.out.println(size);
		else
			System.out.println(tmp.size());
		
	}
}
