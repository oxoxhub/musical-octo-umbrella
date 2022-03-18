package exam07;

public class Initialize {
	public int n1 =10;			//인스턴스 변수
	public static int n2 = 20;	//static 변수
	
	public String s1 = "빈값";	//인스턴스 변수
	public static String s2 = "정적"; //static 변수
	
	public boolean b1 = true;	//인스턴스 변수
	public double d1 = 1.0;		//인스턴스 변수
	
	{//인스턴스 초기화 블럭에 static 변수 가능
		n1 = 20;
		s1 = s1 + "입니다.";
		b1 = !b1;
		d1 += 9;
	}
	
	static { //static 초기화 블록에 인스턴스 변수 불가능
		//n1 = 30;
		//s1 = s1 + "!!!";
		//static 변수가 아니라서 오류가 뜬다.
		
		n2 = 30;
		s2 = s2 + "!!!";
	}

}
