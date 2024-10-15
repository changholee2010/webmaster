package 도서관리;

import java.util.List;
import java.util.Scanner;

import 도서관리.dao.BookDao;
import 도서관리.dao.MemberDao;

public class BookMain {

	static Scanner sc = new Scanner(System.in);
	static MemberDao mdao = MemberDao.getInstance();

	public static void main(String[] args) {
		// 도서관리

		// 메인 메뉴
		Member member = null;
		// 로그인 체크.
		while (true) {
			System.out.println("아이디를 입력>> ");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력>> ");
			String pw = sc.nextLine();

			// 정상적인 로그인되면 "홍길동" 환영메세지.
			member = mdao.checkMember(id, pw);
			if (member != null) {
				System.out.println(member.getMemberName() + " 환영합니다!");
				break;
			}
			System.out.println("아이디와 비밀번호를 확인하세요!");
		} // end of 로그인체크.

		if (member.getResponsibility().equals("User")) {
			// 권한이 User => 도서관리 처리.
			bookManage();
		} else if (member.getResponsibility().equals("Admin")) {
			// 권한이 Admin => 회원관리 처리.
			memberManage();
		}
		sc.close();

	} // end of main.

	static void bookManage() { // 도서관리.
		BookDao dao = new BookDao();

		boolean run = true;
		int cnt = 0;
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.도서등록 2.도서검색 3.도서전체 조회 4.도서삭제 5.도서 정보 변경 6.종료");
			System.out.println("----------------------------------");

			System.out.print("메뉴 선택 > ");
			int selNum = Integer.parseInt(sc.nextLine());

			switch (selNum) {
			case 1: // 선택1번 : 도서등록
				System.out.println("[도서등록]");
				System.out.print("책제목 : ");
				String title = sc.nextLine();
				System.out.print("저자 : ");
				String writer = sc.nextLine();
				System.out.print("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.print("책번호 : ");
				String bnum = sc.nextLine();

				Book book = new Book(title, writer, price, bnum);

				cnt = dao.insert(book);
				if (cnt == 1) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}

				break;
			case 2:// 선택2번 : 도서검색 => 책제목으로 검색 java
				System.out.print("검색 제목 입력>>");
				title = sc.nextLine();
				System.out.print("검색 저자 입력>>");
				writer = sc.nextLine();
				System.out.print("검색 금액 입력>>");
				try {
					price = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					price = 0;
				}

				Search search = new Search();
				search.setPrice(price);
				search.setTitle(title);
				search.setWriter(writer);

				List<Book> list = dao.bookList(search);
				System.out.println("------------------------");
				System.out.println("          검색결과");
				System.out.println("------------------------");
				for (Book bk : list) {
					System.out.println(bk.toString());
				}

				break;
			case 3: // 선택3번 : 도서전체 조회

				break;
			case 4: // 선택4번 : 도서삭제

				break;
			case 5: // 선택5번 : 도서 정보 변경

				break;
			// 책제목 : 변경할 책번호, 변경할 책 가격 입력 => 수정

			case 7: // 선택6번 : 프로그램 종료
				run = false;
				System.out.println("프로그램 종료");

			}
		} // end of while.
	} // end of bookManage();

	static void memberManage() { // 회원관리.
		System.out.println("관리자메뉴입니다.");
		boolean run = true;

		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.회원목록 2.회원등록 3.회원삭제 4.회원정보수정 6.종료");
			System.out.println("----------------------------------");
			System.out.print("메뉴 선택 > ");
			int selNum = Integer.parseInt(sc.nextLine());

			switch (selNum) {
			case 1:
				// 회원목록 출력.
				List<Member> list = mdao.memberList();
				System.out.println("----------------------------------");
				System.out.println("          회원목록");
				System.out.println("----------------------------------");

				for (Member member : list) {
					System.out.println(member.toString());
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 6:
				run = false;
				System.out.println("프로그램 종료");
			} // end of memberManage
		}
	}
}
