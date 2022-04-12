package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * FileOutputStream
		 * 	- 바이트 단위로 파일에 데이터를 쓰기 위해 사용
		 * 	- 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 쓰기 가능
		 */
		
		File f = new File("C:/Users/YULH/file_test.txt");
		
		//인자로 true 하면 덮어쓰기가 아니고 이어쓰기가 된다.
		try (FileOutputStream fos = new FileOutputStream(f, true)){	// fos.close(); 를 쓰거나
			
			fos.write(65);	//아스키 코드
			
			byte[] bArr = new byte[] {66, 67, 68, 69};
			fos.write(bArr);
			
			fos.write("\nFileOutputStream\n".getBytes());	//getBytes()는 문자열을 바이트로 읽어온다
			
			fos.write("한글 쓰기".getBytes());	//마지막에 개행을 하지 않으면 이어쓰기할때 커서 위치에서 그대로 이어쓰기된다.
			
			//메모리 ------> 디스크 사이에 버퍼가 있고 버퍼는 임시저장소같은 것. 버퍼에 있는 것을 지워준다. 꼭 써준다.
			fos.flush();	//이 출력 스트림을 플러시하고 버퍼링된 출력 바이트를 강제로 기록합니다.
			
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}

	}

}
