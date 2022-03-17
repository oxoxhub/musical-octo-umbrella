package exam04;

public class Sample01 {

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		StaticTest.share = 20; //st1.share = 20; 클래스 변수(Static 변수, 공유변수)는 클래스 이름이 붙는게 좋다. 
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		
		StaticTest.share = 20; //st2.share = 30;
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);
		
		StaticTest.share = 20; // st3.share = 40;
		System.out.println(StaticTest.share + "|" + StaticTest.share + "|" + StaticTest.share);
		//System.out.println(st1.share + "|" + st2.share + "|" + st3.share);

		FinalTest ft1 = new FinalTest();
		
		System.out.println(ft1.CONSTANT);
		//ft1.CONSTANT = 20; -> 에러. cannot be assigned.
		
		FinalStaticTest fst1 = new FinalStaticTest();
		FinalStaticTest fst2 = new FinalStaticTest();
		
		System.out.println(fst1.SHARE_CONSTANT + "|" + fst2.SHARE_CONSTANT + "|" + FinalStaticTest.SHARE_CONSTANT);
		// fst1.SHARE_CONSTANT = 20; -> 에러. The final field FinalStaticTest.SHARE_CONSTANT cannot be assigned.
	}

}
