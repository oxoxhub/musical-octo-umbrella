package exam02.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TCPServer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			/*
			 * 1. 네트워크 통신을 위한 IP주소 정보 설정
			 */
			//getByAddress : byte배열을 통해 IP주소를 얻는다.
			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			/*
			 * 2. 서버용 소켓 생성후 서버IP, 서버Port 바인딩
			 */
			
			//InetSocketAddress 이 클래스는 IP 소켓 주소 (IP 주소 + 포트 번호)를 구현합니다. 
			//InetSocketAddress(int port): 포트번호만 주면, 호스트의 IP주소는 임의의 IP주소가 된다. 
			//패킷이 전송할 때 커널에서 알아서 디폴트 디바이스 주소를 부여한다.
			//InetSocketAddress​(InetAddress addr, int port): IP 주소와 포트 번호에서 소켓 주소를 만듭니다.
			InetSocketAddress serverIpPort = new InetSocketAddress(serverIp, serverPort);
			
			
			ServerSocket serverSock = new ServerSocket();
			serverSock.bind(serverIpPort);
			//serverSock.bind(new InetSocketAddress("localhost",5001));
			
			/*
			 * 3. 클라이언트 요청을 대기 후 승낙(accept)하여 클라이언트용 소켓 생성
			 */
				
				Socket sock = serverSock.accept();
			
			/*
			 * 4. 통신용 입출력 스트림 생성
			 */
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			SimpleDateFormat sDate = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 dd초");
			InetAddress clientIp = sock.getInetAddress();
			int clientPort = sock.getPort();
			
			while(true) {
//				while(sIn.ready()) {
//					String strDate = sDate.format(new Date());
//					String line = sIn.readLine();
//					System.out.printf("[%s] [%s:%d] - %s\n", strDate, clientIp.getHostAddress(), clientPort, line);
//				}
				
				//읽기
				String cliMsg = sIn.readLine();
				
				if(cliMsg.equals("exit")) {
					System.out.println("클라이언트가 나갔습니다.");
					break;
				}
				//정상 메세지
				System.out.println("클라이언트 : " + cliMsg);
				
				
				//쓰기
				System.out.println("보내기 >>> ");
				String outMsg = sc.nextLine();
				sOut.write(outMsg + "\n");
				sOut.flush();
				
			}
			
			/*
			 * 5. 모든 데이터 수신을 완료하였으면 모든 자원 반납.
			 */
			sc.close();	
			sIn.close();
			sOut.close();
			sock.close();
			serverSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
