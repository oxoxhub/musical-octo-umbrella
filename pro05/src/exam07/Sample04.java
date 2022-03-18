package exam07;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * 같은 패키지에 다음의 클래스를 만들어본다.
		 * 
		 * 도서 대여 프로그램에 사용할 도서 정보 클래스를 추상화하여 만드시오.
		 * 가급적 다양한 생성자를 만들어 도서 정보를 초기화 한다.
		 * (모든 멤버 변수에 대한 생성자를 만들 필요는 없다.)
		 */
		
		BookRental br1 = new BookRental();
		System.out.println(br1.period);
		BookRental br2 = new BookRental(8);
		System.out.println(br2.period);
		BookRental br3 = new BookRental(9,1);
		System.out.println(br3.period +","+ br3.count);
		BookRental br4 = new BookRental(14,2,"자바의정석");
		System.out.println(br4.period +","+ br4.count +","+ br4.bookname);

	}

}
