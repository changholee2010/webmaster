package chap06;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Book[]  books = null; 
		int bookCnt = 0;
		
		while(run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.도서 수 | 2. 도서 등록 | 3.도서 조회 | 4. 도서 분석 | 5. 종료");
			System.out.println("--------------------------------------------------------");
			
			System.out.print("메뉴 선택 > ");
			int menuNo = Integer.parseInt(sc.nextLine());
			
			switch(menuNo) {
				case 1 :
					System.out.print("도서 수 > ");
					bookCnt = Integer.parseInt(sc.nextLine());
					books = new Book[bookCnt];
					break;
				case 2 :
					for(int i = 0; i<bookCnt; i++) {
						
						System.out.println((i + 1) +"번째 도서 입력");
						System.out.print("책 제목 > ");
						String title = sc.nextLine();
						
						System.out.print("책 번호 > ");
						String bookNum = sc.nextLine();
						
						System.out.print("책 가격 > ");
						int price = Integer.parseInt(sc.nextLine());
						
						books[i] = new Book(title, bookNum, price);
					}
					break;
				case 3 :
					for(Book book : books) {
						System.out.printf("%s\t%s\t%d\n", book.getBookNo(), book.getTitle(), book.getPrice());
					}
					break;
				case 4 :
					int sum = 0;
					String title = null;
					int max = Integer.MIN_VALUE;
					int min = Integer.MAX_VALUE;
					for(Book book : books) {
						int p = book.getPrice();
						sum += p; //합
						if(max < p) {
							max = p; //최대값
							title = book.getTitle();
						}
						if(min > p) min = p; //최소값
					}
					
					System.out.printf("합 = %d, 최대 가격 = %d, 최소 가격 = %d\n", sum, max, min);
					System.out.println("가장 비싼 책 : " + title);
					break;
				case 5 :
					run = false;
					break;
				default :
					System.out.println("메뉴를 다시 선택하세요");
			}
			
		}
		sc.close();
		System.out.println("프로그램 종료");

	}//end main

}//end class
