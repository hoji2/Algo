
public class Program_Lv1_문자열내p와y의개수 {

    boolean solution(String s) {
    	 
        int p=0;
        
        s=s.toUpperCase();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='P')
                p++;
            else if(s.charAt(i)=='Y')
                p--;
        }            
        if(p==0)
            return true;
        
        return false;

    }
}
