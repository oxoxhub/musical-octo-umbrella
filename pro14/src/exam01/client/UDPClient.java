package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try {
			/*
			 * 1.네트워크 통신을 위한 IP주소 정보 설정
			 */
			
			//getByName :도메인명(host)을 통해 IP주소를 얻는다
//			InetAddress ip = InetAddress.getByName("localhost");
			
			//getByAddress : byte배열을 통해 IP주소를 얻는다.
//			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
//			InetAddress ip = InetAddress.getByAddress(addr);
			
			//getHostAddress : 호스트의 IP주소를 반환한다.
//			System.out.println(ip.getHostAddress());
			
			//getLocalHost : 지역 호스트의 IP주소를 반환한다.
			InetAddress clientIp = InetAddress.getLocalHost();
			int clientPort = 50000;
			
			byte[] addr = new byte[] {(byte)58,(byte)127,(byte)192,(byte)220};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 51000;
			
			/*
			 * 2. UDP통신용 소켓 생성
			 */
			DatagramSocket udpSock = new DatagramSocket(clientPort, clientIp);
			
			/*
			 * 3. 서버에 데이터를 송신하기 위한 패킷 생성. (서버가 활성되어 있어야 한다.)
			 */
			
			
//			byte[] data = "Hello.".getBytes();
//			DatagramPacket packet = new DatagramPacket(data, data.length, serverIp, serverPort);
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("사용자 입력하세요. : ");
				String str = sc.nextLine();
				byte[] bdata = str.getBytes();
				DatagramPacket packet = new DatagramPacket(bdata, bdata.length, serverIp, serverPort);
				
				udpSock.send(packet);
			}
			/*
			 * 4. 데이터 송신을 완료하였으면 모든 자원 반납.
			 */
//			udpSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}












