
public class Program_Lv1_자릿수더하기 {

public int solution(int n) {
        
        String s=Integer.toString(n);
        int res=0;
        
        for(int i=0; i<s.length(); i++)
            res+=s.charAt(i)-'0';
                
        return res;
    }
}
