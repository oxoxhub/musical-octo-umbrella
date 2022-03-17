package exam02.pack2;

import exam02.pack1.PublicAccessTest;
import exam02.pack1.DefaultAccessTest;
//The type exam02.pack1.DefaultAccessTest is not visible

public class Sample02 {

	public static void main(String[] args) {
		PublicAccessTest p = new PublicAccessTest();
		DefaultAccessTest d = new DefaultAccessTest();
	}

}
