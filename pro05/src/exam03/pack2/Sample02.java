package exam03.pack2;

import exam03.pack1.AccessMain;

public class Sample02 {

	public static void main(String[] args) {
		AccessMain a = new AccessMain();
		System.out.println(a.v1); // public은 전체에서 가능.
		System.out.println(a.v2); // 같은 패키지 내에서만 가능해서.
		System.out.println(a.v3); // 같은 패키지 내에서만 가능해서.
		System.out.println(a.v4); // 같은 패키지 내에서만 가능해서.
	}

}
