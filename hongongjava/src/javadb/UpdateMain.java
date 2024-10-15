package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		// 연결하기
		Connection conn = null;
		
		try {
			//jdbc 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe", // url
					"java", //계정
					"1234" // 비밀번호
					);
			System.out.println("연결성공");
			
			//데이터 수정
			String sql = "" +
						"update boards " + 
						"set btitle=?, bcontent=? " +
						"where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle","bcontent"});
			pstmt.setString(1, "행복");
			pstmt.setString(2, "바람이 간지러워요");
//			pstmt.setInt(3, 5);
			pstmt.setString(3, "글쓴이5");
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
			
//			if(rows == 1) {
//				ResultSet rs = pstmt.getGeneratedKeys();
//				if(rs.next()) {
//					int bno = rs.getInt(1);
//					String title = rs.getString(1);
//					String content = rs.getString(2);
//					System.out.printf("수정된 내용 : %s : %s", title, content);
//				}
//			}
			
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
