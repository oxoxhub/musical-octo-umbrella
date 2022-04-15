package exam01.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPServer {

	public static void main(String[] args) {
		try {
			/*
			 * 1.네트워크 통신을 위한 IP주소 정보 설정
			 */
			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 51000;
			
			/*
			 * 2. UDP통신용 소켓 생성
			 */
			DatagramSocket udpSock = new DatagramSocket(serverPort, serverIp);
			
			while(true) {
				/*
				 * 3. 클라이언트가 서버에 송신한 데이터를 수신하기 위한 패킷 생성. 
				 * 		(서버가 활성되어 있어야 한다.)
				 */
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				udpSock.receive(packet);
				
				/*
				 * 수신한 패킷에서 클라이언트 정보 확인
				 */
				InetAddress clientIp = packet.getAddress();
				int clientPort = packet.getPort();
				
				/*
				 * 4. 수신한 데이터를 출력하여 확인
				 */
				String msg = new String( packet.getData());
				
				SimpleDateFormat sDate = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 dd초");
				String strDate = sDate.format(new Date());
				System.out.printf("[%s] [%s:%d] - %s\n", strDate, clientIp.getHostAddress(), clientPort, msg);
				
			}
			
			/*
			 * 5. 데이터 송신을 완료하였으면 모든 자원 반납.
			 */
			//udpSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
