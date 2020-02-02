import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11656_접미사배열 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String s=sc.nextLine();
		String[]tmp=new String[s.length()];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i]=s.substring(i, s.length());
		}
		
		Arrays.sort(tmp, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i]);
		}
	}
}
