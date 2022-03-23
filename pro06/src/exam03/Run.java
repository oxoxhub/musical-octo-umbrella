package exam03;

public class Run {

	public static void main(String[] args) {
		Page page = new Page(55, 100);
		
		for(int i = 0; i < page.getLimitPageNumber(); i++) {
			page.nextPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");
		}
		
		while(page.existsPrevPage()) {
			page.prevPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");
		}

	}

}
