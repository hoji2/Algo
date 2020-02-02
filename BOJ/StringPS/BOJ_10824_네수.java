import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10824_네수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//Long.maxValue 찍어봐서 최대값에서 long이 꺠지는 지 여부 파악
		StringTokenizer st=new StringTokenizer(sc.nextLine());
		
		long a=Long.parseLong(st.nextToken()+st.nextToken());
		long b=Long.parseLong(st.nextToken()+st.nextToken());

		System.out.println(a+b);
		
	}
}

// 만일 long 범위가 깨지는 경우 아래와 같이 자리수별로 탐색하여 저장

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10824_네수 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		StringTokenizer st=new StringTokenizer(sc.nextLine());
		
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		StringBuffer fin=new StringBuffer();

		sb1.append(st.nextToken()+st.nextToken());
		sb2.append(st.nextToken()+st.nextToken());
	
		// StringBuffer의 length는 리스트 처럼 add할 때 마다 유동적으로 변화한다
		// 초기 사이즈를 변수화하여 loop처리
		int a=sb1.length();
		int b=sb2.length();
		
		// 자리수 맞추기 작업
		if(a>b) {
			for (int i = 0; i <a-b; i++) {
				sb2.insert(0, 0);
			}
		}else if(b>a){
			for (int i = 0; i <b-a; i++) {
				sb1.insert(0, 0);
			}
		}
		
		// 이전 자리수에서 올라오는 carry
		int c=0;
		for (int i = sb2.length()-1; i >=0; i--) {
			// sb에 get(i), charAt(i)같은 메소드가 없어서 한글자 추출을 substring으로 대체
			int t1=Integer.parseInt(sb1.substring(i, i+1));
			int t2=Integer.parseInt(sb2.substring(i, i+1));
			
			int tmp=t1+t2+c;
			if(tmp>9) {
				c=1;
				tmp=tmp%10;
			}else {
				c=0;
			}
			fin.append(tmp);
		}
		
		//마지막 올림수
		if(c==1)
			fin.append(1);
		
		
		System.out.println(fin.reverse());
	}
}
