package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * FileInputStream 클래스
		 * 	- 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 * 	- 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 읽기 가능
		 */
		
		File f = new File("C:/Users/YULH/file_test.txt");
		try {
			FileInputStream fis = new FileInputStream(f);	//FileNotFoundException
			
			/*
			 * 기본
			 * 
			while(true) {
				int i = fis.read();	//IOException
				//스트림을 통해 읽은 데이터가 -1이 아니면 바이트 데이터이다.
				if(i == -1) {	//the next byte of data, or -1 if the end of the file is reached.
					break;
				}
				System.out.print((char)i);	// i의 값이 아스키코드로 출력된다. char로 형변환해주면 문자가 나온다.
			}
			*/
			
			/*
			 * 1바이트씩 읽고 저장하는 방식
			 * 한글을 읽기위해서는 스트링에 담고 출력해야한다.
			 * 
			byte[] bytes = new byte[0];		// 한글 읽기위한 배열 활용
			while(true) {
				int i = fis.read();	//IOException
				//스트림을 통해 읽은 데이터가 -1이 아니면 바이트 데이터이다.
				if(i == -1) {	//the next byte of data, or -1 if the end of the file is reached.
					break;
				}
				bytes = Arrays.copyOf(bytes, bytes.length +1);	// 한글 읽기위한 배열 활용
				bytes[bytes.length -1 ] = (byte)i;	// 한글 읽기위한 배열 활용
			}
			System.out.println(new String(bytes)); //스트링에 바이트배열로 받는 것이 존재한다.
			*/
			
			
			byte[] buffer = new byte[4];		//괄호안에 지정한 숫자 크기만큼 배열이 만들어지고 길이만큼 바이트를 읽는다.
			byte[] bytes = new byte[0];		// 한글 읽기위한 배열 활용
			while(true) {
				int i = fis.read(buffer);	//괄호안에 지정한 숫자 크기만큼 바이트를 읽는다. i = 4;
				//스트림을 통해 읽은 데이터가 -1이 아니면 바이트 데이터이다.
				if(i == -1) {	//the next byte of data, or -1 if the end of the file is reached.
					break;
				}
				bytes = Arrays.copyOf(bytes, bytes.length +i);
				System.arraycopy(buffer, 0, bytes, bytes.length - i , i);
				
			}
			System.out.println(new String(bytes));
			
			fis.close();		// 안하면 메모리 누수의 원인이 됨.
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("해당 파일을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}	
		
		
		
	}

}
