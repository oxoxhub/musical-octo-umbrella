package exam07;

public class Constructor01 {
	public int num1;
	public int num2;
	public int num3;
	public int num4;
	
	
	public Constructor01() {}
	
	public Constructor01(int num1) {
		this.num1 = num1;
	}
	
	public Constructor01(int num1, int num2) {
		//생성자 this()
		//생성자에서 다른 생성자 호출 할 때 사용.
		//다른 생성자 호출시 첫 줄에서만 사용.
		this(num1);
		this.num2 = num2;
	}
	
	public Constructor01(int num1, int num2, int num3) {
		this(num1, num2);
		this.num3 = num3;
	}
	
	public Constructor01(int num1, int num2, int num3, int num4) {
		this(num1, num2, num3);
		this.num4 = num4;
	}


}
