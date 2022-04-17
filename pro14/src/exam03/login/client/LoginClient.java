package exam03.login.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginClient {

	/*
	 * 로그인 클라이언트
	 * 		1. 아이디와 패스워드를 입력하여 서버에 로그인 요청
	 * 		2. 서버로 부터의 로그인 승낙을 받으면 연결됨.
	 * 		3/ 서버로 부터의 로그인 승낙을 받지 못하면 연결 종료.
	 */
	


	public static void main(String[] args) {
		try {
			
			/*
			 * 1. 네트워크 통신을 위한 IP주소 정보 설정
			 */
			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			/*
			 * 2. 클라이언트용 소켓 생성
			 */
			Socket sock = new Socket(serverIp, serverPort);
			
			/*
			 * 3. 통신용 입출력 스트림 생성
			 */
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			Scanner sc = new Scanner(System.in);
			;
			
			
			while(true) {
				System.out.println("아이디 입력: ");
				String id = sc.nextLine();
				System.out.println("비밀번호 입력: ");
				String password = sc.nextLine();
				sOut.write(id + "\n");
				sOut.write(password + "\n");
//				sOut.newLine();
				sOut.flush();
				
			}
			/*
			 * 4. 데이터 송신을 완료하였으면 모든 자원 반납
			 */
//			sIn.close();
//			sOut.close();
//			sock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
