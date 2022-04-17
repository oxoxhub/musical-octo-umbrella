package exam03.login.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class LoginServer {
	
	/*
	 * 로그인 서버
	 * 		1. 클라이언트가 아이디와 패스워드로 연결 요청을 하면
	 * 			account.db 파일에 있는 사용자 정보를 확인
	 * 		2. account.db 파일에 동일한 아이디, 패스워드가 존재하는 
	 * 			경우 로그인 승낙을 함.
	 * 		3. account.db 파일에 동일한 아이디, 패스워드가 없는 경우
	 * 			연결 끊음.
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
			 * 2. 서버용 소켓 생성후 서버IP, 서버Port 바인딩
			 */
			ServerSocket serverSock = new ServerSocket();
			InetSocketAddress serverIpPort = new InetSocketAddress(serverIp, serverPort);
			serverSock.bind(serverIpPort);
			
			/*
			 * 3. 클라이언트 요청을 대기 후 승낙(accept)하여 클라이언트용 소켓 생성
			 */
			
			Socket sock = serverSock.accept();
			/*
			 * 4. 통신용 입출력 스트림 생성
			 */			
		
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			String userHome = System.getProperty("user.home");
			File file = new File(userHome + "/account.db.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String[] sArr2 = new String[0];
			
			while(br.ready()) {	
				String line = br.readLine();	// 한줄씩 읽음
				String[] temp = Arrays.copyOf(sArr2, sArr2.length + 1);
				System.arraycopy(sArr2, 0, temp, 0, sArr2.length); 
				temp[temp.length - 1] = line;
				sArr2 = temp;
			}
			
//			String line = "입력 안됌";
			while(true) {
				String[] sArr = new String[0];
				while(sIn.ready()) {
					for(int j = 0; j < sArr2.length; j++) {
						String line = sIn.readLine();
						String[] temp = Arrays.copyOf(sArr, sArr.length + 1);
						System.arraycopy(sArr, 0, temp, 0, sArr.length); 
						temp[temp.length - 1] = line;
						sArr = temp;
					}
//					System.out.println(Arrays.toString(sArr));

					for(int i = 0; i<sArr2.length; i += 2) {
						if(sArr[i].equals(sArr2[i]) && sArr[i+1].equals(sArr2[i+1])) {
							System.out.println("로그인 성공!!");
						} else {
							System.out.println("로그인 실패");
							sIn.close();
//							sOut.close();
//							sock.close();
//							serverSock.close();
//							System.out.println("소켓 닫기1");
						}
						
					}
				}
			}

			
			/*
			 * 5. 모든 데이터 수신을 완료하였으면 모든 자원 반납.
			 */
//			sIn.close();
//			sOut.close();
//			sock.close();
//			serverSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	

}
