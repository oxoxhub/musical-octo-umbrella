package exam03.pack2;

import exam03.pack1.AccessParent;

//상속 부모는: AccessParent 자식은: AccessChild
public class AccessChild extends AccessParent {
//지금 이 클래스는 후손 클래스이다.
	
	public void method() {
		System.out.println(p1); // + public 접근 가능
		System.out.println(p2); // # protected 접근 가능
		System.out.println(p3);	// ~ default 접근 불가능
		System.out.println(p4);	// - private 접근 불가능
	}
}
