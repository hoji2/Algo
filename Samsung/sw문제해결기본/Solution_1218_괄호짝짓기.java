import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		for (int tc = 1; tc <=10; tc++) {
	
			sc.nextInt();
			sc.nextLine();
			char[]arr=sc.nextLine().toCharArray();
			Stack<Character> stack=new Stack<Character>();
			boolean valid=true;
			
			for(char p : arr) {
				if(p==')') {
					if(stack.isEmpty()) {
						valid=false;
						break;
					}else {
						if(stack.pop()!='(') {
							valid=false;
							break;
						}
					}
				}else if(p==']') {
					if(stack.isEmpty()) {
						valid=false;
						break;
					}else {
						if(stack.pop()!='[') {
							valid=false;
							break;
						}
					}
				}else if(p=='}') {
					if(stack.isEmpty()) {
						valid=false;
						break;
					}else {
						if(stack.pop()!='{') {
							valid=false;
							break;
						}
					}
				}else if(p=='>') {
					if(stack.isEmpty()) {
						valid=false;
						break;
					}else {
						if(stack.pop()!='<') {
							valid=false;
							break;
						}
					}
				}else {
					stack.add(p);
				}
			}
			
			if(!valid)
				System.out.println("#"+tc+" "+0);
			else {
				if(stack.isEmpty())
					System.out.println("#"+tc+" "+1);
				else
					System.out.println("#"+tc+" "+0);
			}
		}
	}
}
