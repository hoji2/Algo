import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11651_좌표정렬하기2 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<point>tmp=new ArrayList<point>();
		int n=sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			tmp.add(new point(sc.nextInt(), sc.nextInt()));
		}
		
		tmp.sort(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				
				if(o1.x==o2.x)
					return o1.y-o2.y;
				
				return o1.x-o2.x;
			}
		});
		
		for (int i = 0; i < n; i++) {
			point p=tmp.get(i);
			System.out.println(p.x+" "+p.y);
		}
		
	}
}

class point{
	int x,y;
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}