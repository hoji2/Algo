
public class Program_Lv2_방금그곡_못품 {

	//https://daily-life-of-bsh.tistory.com/103
	public static void main(String[] args) {
		
//		String m="ABCDEFG";
//		String[]map= {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
//		String m="ABC";
//		String[]map= {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		
		String t="CC#BCC#BCC#BCC#B";
		String[]map= {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		
		String res="";
		StringBuilder m=new StringBuilder();
		
		for (int i = 0; i < t.length(); i++) {
			if(i==t.length()-1)
				m.append(t.charAt(i));
			else if(t.charAt(i+1)=='#') {
				char p1=(char) ((int)t.charAt(i)+32);
				m.append(p1);
				i++;
			}else
				m.append(t.charAt(i));
		}
		
		for(String p : map) {
			String[]tmp=p.split(",",-1);
			
			// tmp[0] tmp[1] tmp[2] tmp[3];
			int hour=Integer.parseInt(tmp[1].substring(0, 2))-Integer.parseInt(tmp[0].substring(0, 2));
			int min=Integer.parseInt(tmp[1].substring(3, 5))-Integer.parseInt(tmp[0].substring(3, 5));
			
			int idx=0;
			int time=0;
			StringBuilder sb=new StringBuilder();
			while(time<2*hour+min) {
				char p1=tmp[3].charAt(idx%tmp[3].length());
				char p2=tmp[3].charAt((idx+1)%tmp[3].length());
				
				if(p2=='#') {
					p1=(char) ((int)p1+32);
					idx+=2;
				}else {
					idx++;
				}
				sb.append(p1);
				time++;
				
			}
			
			if(sb.toString().contains(m.toString())) {
				res=tmp[2];
				break;
			}
		}
		if(res.equals(""))
			System.out.println("(None)");
		System.out.println(res);
	}
}
