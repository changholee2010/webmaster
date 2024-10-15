package 도서관리.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import 도서관리.Book;
import 도서관리.Search;

public class BookDao extends DAO {

	// 데이터 추가
	// 3.insert 메소드
	public int insert(Book book) {
		getOpen();
		try {
			String sql = "" + "insert into book (title,writer,price,bnum) " + "values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBnum());

			// sql문장 실행
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	// 4.select : 조건에 따른 검색(책제목) 메소드
	public List<Book> bookList(Search search) {
		getOpen();
		String sql = "select * from book"//
				+ "   where price <> 0";
		if (search.getTitle() != null || !search.getTitle().equals("")) {
			sql += "  and title like '%'||?||'%'";
		}
		if (search.getWriter() != null || !search.getWriter().equals("")) {
			sql += "  and writer like '%'||?||'%'";
		}
		if (search.getPrice() > 0) {
			sql += "  and price > ?";
		}
		int param = 1;
		List<Book> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getTitle() != null || !search.getTitle().equals("")) {
				psmt.setString(param++, search.getTitle());
			}
			if (search.getWriter() != null || !search.getWriter().equals("")) {
				psmt.setString(param++, search.getWriter());
			}
			if (search.getPrice() > 0) {
				psmt.setInt(param++, search.getPrice());
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getString("title")//
						, rs.getString("writer")//
						, rs.getInt("price")//
						, rs.getString("bnum"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;
	}

	// 5.select : 목록전체 조회 메소드

	// 6.delete 메소드 (북번호 이용)
	// 7.update 메소드(책제목의 가격과 책번호 수정)

}
