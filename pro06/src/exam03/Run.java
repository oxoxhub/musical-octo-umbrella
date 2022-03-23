package exam03;

public class Run {

	public static void main(String[] args) {
		Page page = new Page(100);
		System.out.println(page.getPageNumber() + " 페이지 입니다.");
		page.nextPage();
		System.out.println(page.getPageNumber() + " 페이지 입니다.");
		page.nextPage(42);	
		System.out.println(page.getPageNumber() + " 페이지 입니다.");
		page.movePage(78);
		System.out.println(page.getPageNumber() + " 페이지 입니다.");
		
		for(int i = 0; i < page.getLimitPageNumber(); i++) {
			page.nextPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");
		}
				
		while(page.existsPrevPage()) {
			page.prevPage();
			System.out.println(page.getPageNumber() + " 페이지 입니다.");
		}
		
		
		System.out.println("------------------");
		
		
		Page page1 = new Page(124,150);
		System.out.println(page1.getPageNumber() + " 페이지 입니다.");
		System.out.println(page1.getLimitPageNumber() + " 페이지까지 입니다.");
		
//		for(int i = 0; i < page1.getLimitPageNumber(); i++) {
//			page1.nextPage();
//			System.out.println(page1.getPageNumber() + " 페이지 입니다.");
//		}
		
		while(page1.existsNextPage()) {
			page1.nextPage();
			System.out.println(page1.getPageNumber() + " 페이지 입니다.");
		}
	}

}
