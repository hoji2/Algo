import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10814_나이순정렬 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<mem>tmp=new ArrayList<mem>();
		int n=sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			tmp.add(new mem(sc.nextInt(),i, sc.nextLine()));
		}
		
		tmp.sort(new Comparator<mem>() {

			@Override
			public int compare(mem o1, mem o2) {
				
				if(o1.age==o2.age)
					return o1.idx-o2.idx;
				
				return o1.age-o2.age;
			}
		});
		
		for (int i = 0; i < n; i++) {
			mem m=tmp.get(i);
			System.out.println(m.age+m.s);
		}
	}
}

class mem{
	int age, idx;
	String s;
	
	public mem(int age, int idx, String s) {
		this.age=age;
		this.idx=idx;
		this.s=s;
	}
}

