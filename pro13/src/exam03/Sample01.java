package exam03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Sample01 {
	
	public static void main(String[] args) {
		/*
		 * 보조 스트림
		 * 		- 입출력에 사용하는 기반 스트림을 보조하는 역할을 수행한다.
		 * 		- 기반 스트림의 기능의 성능을 높이거나 추가 기능을 부여하기 위해 사용
		 * 		- 보조 스트림은 기반 스트림을 사용해야 쓸 수 있다.(단독 사용 불가)
		 */
		Sample01 s = new Sample01();
//		s.ex01();
		s.ex02();
//		s.ex03();
//		s.ex04();
	}

	
	public void ex01() {
		/*
		 * 문자 변환 보조 스트림
		 * 		:소스 스트림이 바이트 기반 스트림이지만 데이터가 문자일 경우 사용가능하다.
		 * 		- 바이트 기반 스트림과 같이 사용하는 보조 스트림 -> InputStreamReader, OutputStreamWriter
		 */
		String userHome = System.getProperty("user.home");
		File file = new File(userHome + "/보조스트림.테스트");
		String str = "문자열 테스트";
		//String[] sArr = new String[] {"가나", "다라"};
		
		//쓰기
		try(OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(file))){
			fos.write("바이트 기반 스트림 + 문자 변환 보조 스트림");
			fos.write(str);
			//fos.write(sArr);	문자열 배열은 입력 불가능하다.
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//읽기
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(file))){
			StringBuilder sb = new StringBuilder();
			//기반 스트림은 바이트지만 보조 스트림이 문자로 바꿔주기때문에 char로 받는다.
			char[] buff = new char[1024];
			
			while(isr.ready()) {		// ready(): 읽을 데이터가 있냐 없냐 boolean형으로 나온다
				int size = isr.read(buff);
				sb.append(buff, 0 , size);
			}
			
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ex02() {
		/*
		 * 성능 향상 보조 스트림
		 * 		- 바이트 기반 스트림과 같이 사용하는 보조 스트림 -> BufferedInputStream, BufferedOutputStream
		 * 		- 문자 기반 스트림과 같이 사용하는 보조 스트림 -> BufferedReader, BufferedWriter
		 */
		String userHome = System.getProperty("user.home");
		File file = new File(userHome + "/보조스트림.테스트");
		
		//쓰기
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
			bos.write("바이트 기반 스트림 + 버퍼 보조 스트림".getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//읽기
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			StringBuilder sb = new StringBuilder();
			
			while(bis.available() > 0) {	//available() : 0 이상이면 진행하라.
				//int available() : 현재 읽을 수 있는 바이트수를 반환한다.
				int size = bis.available();
				byte[] bytes = new byte[size];
				bis.read(bytes, 0, size);
				// int read(byte[] b ,int off ,int len)
				// : len만큼 읽어서 byte[] b의 off위치에 저장하고 읽은 바이트 수를 반환한다.

				sb.append(new String(bytes));
			}
			
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//쓰기
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write("문자 기반 스트림 + 버퍼 보조 스트림");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//읽기
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			StringBuilder sb = new StringBuilder();
			
			while(br.ready()) {	
				String line = br.readLine();	// 한줄씩 읽음
				sb.append(line);
			}
			
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void ex03() {
		/*
		 * 기본 데이터 타입 보조 스트림
		 * 		- 바이트 기반 스트림과 같이 사용하는 보조 스트림 -> DataInputStream, DataOutputStream
		 */
		String userHome = System.getProperty("user.home");
		File file = new File(userHome + "/보조스트림.테스트");
		
		//쓰기
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
			dos.writeBoolean(false);
			dos.writeInt(100);
			dos.writeDouble(12.34);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//읽기
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			double d = dis.readDouble();
			
			System.out.println(b);
			System.out.println(i);
			System.out.println(d);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ex04() {
		/*
		 * 객체 보조 스트림
		 *			- 바이트 기반 스트림과 같이 사용하는 보조 스트림 -> ObjectInputStream, ObjectOutputStream
		 */
		String userHome = System.getProperty("user.home");
		File file = new File(userHome + "/보조스트림.테스트");
		
		//쓰기
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			ObjSample os = new ObjSample(100, 12.34, true, "객체를 파일로 저장");
			oos.writeObject(os);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//읽기
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			Object obj = ois.readObject();
			ObjSample os = (ObjSample) obj;
			System.out.println(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

}
