package chap13;

import java.util.List;

public class BoardExam604 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getList();
		for(Board bd : list) {
			System.out.println(bd);
		}
	}

}
