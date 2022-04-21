package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * FileWriter
		 * 	- 문자 기반 스트림으로 문자 단위로 파일을 쓴다.
		 * 	- 보통 텍스트 파일을 쓰기 위해 사용
		 */
		
//		File f = new File("C:/Users/YULH/file_test.txt");
		FileWriter fw = null;
		
		//인자로 true 하면 덮어쓰기가 아니고 이어쓰기가 된다.
		//try (FileWriter fw = new FileWriter(f, true))
//		try (FileWriter fw = new FileWriter(f)){	// fw.close(); 를 쓰거나
		
		try {
			fw = new FileWriter("C:/Users/YULH/file_test.txt", true);
			
			fw.write(65);	//아스키 코드
			
			char[] cArr = new char[] {66, 67, 68, 69};
			fw.write(cArr);
			
			fw.write("\nFileOutputStream\n");	//문자 단위라서 getByte할 필요없다.
			
			fw.write("한글 쓰기\n");	//마지막에 개행을 하지 않으면 이어쓰기할때 커서 위치에서 그대로 이어쓰기된다.
			
			//메모리 ------> 디스크 사이에 버퍼가 있고 버퍼는 임시저장소같은 것. 버퍼에 있는 것을 지워준다. 꼭 써준다.
			fw.flush();	//이 출력 스트림을 플러시하고 버퍼링된 출력 바이트를 강제로 기록합니다.
			
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}

	}

}
