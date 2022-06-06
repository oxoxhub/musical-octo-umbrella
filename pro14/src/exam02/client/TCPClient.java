package exam02.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			
			/*
			 * 1. 네트워크 통신을 위한 IP주소 정보 설정
			 */
			//getByAddress : byte배열을 통해 IP주소를 얻는다.
			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
//			String serverIp = InetAddress.getLocalHost().getHostAddress();
			
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
			while(true) {
				System.out.println("사용자 입력 >>> ");
				String str = sc.nextLine();
				
				if(str.equals("exit")) {
					sOut.write(str + "\n");
					sOut.flush();
					break;
				}
				
				//정상 메세지
				sOut.write(str + "\n");
//				sOut.newLine();
				sOut.flush();
				
				//읽기
				String msg = sIn.readLine();
				System.out.println("서버 : " + msg);
				
				
			}
			/*
			 * 4. 데이터 송신을 완료하였으면 모든 자원 반납
			 */
			sc.close();	
			sIn.close();
			sOut.close();
			sock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
