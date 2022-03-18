package exam07;

public class BookRental {
	
	public String bookname; //도서이름
	public String serialNo; //도서장르
	public int period; //대여기간
	public int count; //대여개수
	
	public BookRental() {
		this.period = 7;
	}
	public BookRental(int period) {
		this.period = period;
	}
	public BookRental(int period, int count) {
		this(period);
		this.count = count;
	}
	
	public BookRental(int period, int count, String bookname) {
		this(period, count);
		this.bookname = bookname;
	}
	
	void rent() {} //대여하기
	void bookreturn() {} //반납하기
	void extension() {} //대여연장
}
