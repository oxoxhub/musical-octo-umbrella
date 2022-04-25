package exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("myId", 1234);
		map.put("asdf", 1111);
		map.put("asdf", 1234);
		System.out.println(map);

		Scanner s = new Scanner(System.in);	// 화면으로부터 라인단위로 입력받는다.

		while(true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id :");
			String id = s.nextLine().trim();	//trim() 공백제거해주는 메서드

			System.out.print("password :");
			Integer password = s.nextInt();
//			String password = s.nextLine().trim();
			System.out.println();

			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;	//처음으로 돌아간다.
			} 
			
			if(!(map.get(id)).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
		} // while
	}

}
