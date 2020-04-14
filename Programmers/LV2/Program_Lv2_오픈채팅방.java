import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Program_Lv2_오픈채팅방 {

	public static void main(String[] args) {
		
//		String[]record= {"Enter uid1234 Muzi", "Enter uid4567 Muzi","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Prodo","Change uid4567 hoji"};
		String[]record={"Enter uid0606 Gimoi", "Enter uid4567 Prodo", "Leave uid0606", "Enter uid1234 Prodo", "Change uid1234 OhYeah"};
		// 아 닉네임 중복처리
		
		
		// 순서 있는 해쉬로 저장해야함
		LinkedHashMap<String, String> info=new LinkedHashMap<String, String>();
		int cnt=0;
		//상태변화 체크 + 출력 명령어 개수 cnt
		for(String s : record) {
			StringTokenizer st=new StringTokenizer(s);
			String command=st.nextToken();
			String id=st.nextToken();
			//leave는 명령어 카운트만 증가
			if(command.equals("Leave")) {
				cnt++;
				continue;
			}
			
			String nick=st.nextToken();
			if(command.equals("Enter")) {
				cnt++;
				//최초입장
				if(!info.containsKey(id))
					info.put(id, nick);
				//나갔다 재입장
				else {
					//닉네임 바뀐경우
					if(!info.get(id).equals(nick)) {
						info.put(id, nick);
					}
					//안바뀌면 그대로
				}
			}
			// change는 정보만 바꿔준다.
			else if(command.equals("Change"))
				info.put(id, nick);
		}
		
		//출력
		
		String[]res=new String[cnt];
		int idx=0;
		for(String s: record) {
			StringTokenizer st=new StringTokenizer(s);
			String command=st.nextToken();
			String id=st.nextToken();
			
			if(command.equals("Enter"))
				res[idx++]=info.get(id)+"님이 들어왔습니다.";
			else if(command.equals("Leave"))
				res[idx++]=info.get(id)+"님이 나갔습니다.";
			
		}
		
		for(String s : res)
			System.out.println(s);
		
	}
	
}
