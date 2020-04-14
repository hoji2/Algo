
public class Program_Lv2_JadenCase문자열만들기 {

	//https://jpcs.tistory.com/28
	public static void main(String[] args) {
		
		String s="3people unFollowed me ";
		s=s.toLowerCase();
		String[]tmp=s.split(" ",-1);
		StringBuilder sb=new StringBuilder();
	      
		for(String p : tmp){
			if(p.equals(""))
				sb.append(" ");
			else if(p.charAt(0)>=97 && p.charAt(0)<=122){
				String q=((char)(p.charAt(0)-32))+p.substring(1);
				sb.append(q);
				sb.append(" ");
			}else {
				sb.append(p);
				sb.append(" ");
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb.toString());
	}
}
