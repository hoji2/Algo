
public class Program_Lv2_숫자야구 {

	public static void main(String[] args) {
		
		int[][] map= {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		
		int res=0;
		
		for (int i = 123; i <=987; i++) {
			String s=Integer.toString(i);
			char p=s.charAt(0);
			char q=s.charAt(1);
			char r=s.charAt(2);
			
			if(p=='0' || q=='0' || r=='0') continue;
			if(p==q || q==r || r==p) continue;
			
			boolean flag=true;
			for (int j = 0; j < map.length; j++) {
				int strike=0;
				int ball=0;
				// a, b 각각의 자리수
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						String num=Integer.toString(map[j][0]);
						
						if(a==b && s.charAt(a)==num.charAt(b)) {
							strike++;
							continue;
						}
						
						if(a!=b && s.charAt(a)==num.charAt(b)) {
							ball++;
							continue;
						}
					}
				}
				
				if(strike !=map[j][1] || ball !=map[j][2]) {
					flag=false;
					break;
				}
			}
			
			if(flag)
				res++;
		}
		System.out.println(res);
	}
	
}
