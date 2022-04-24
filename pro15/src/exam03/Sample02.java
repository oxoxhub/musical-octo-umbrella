package exam03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Sample02 {

	public static void main(String[] args) {
		
		/*
		 * Properties :
		 * 키와 값을 String타입으로 제한한 Map컬렉션
		 */
		String userHome = System.getProperty("user.home");
		String file = "/eclipse/jee-2021-12/eclipse/configuration/config.ini";
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File(userHome + file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		
		//eclipse.product는 키이고 org.eclipse.platform.ide는 값이다. = 등호로 구별
		System.out.println(prop.get("eclipse.product"));
		System.out.println(prop.getProperty("eclipse.product"));
		
		prop.put("x", "100");
		prop.put("key", "Hello");
		prop.setProperty("name", "eclipse");
		
		String otherFile = "/eclipse/jee-2021-12/eclipse/configuration/config.copy";
		
		// "This is Comment"는 주석이다.
		try {
			prop.store(new FileOutputStream(new File(userHome + otherFile)), "This is Comment");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
