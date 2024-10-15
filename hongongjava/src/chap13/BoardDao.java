package chap13;

import java.util.LinkedList;
import java.util.List;

public class BoardDao {
	List<Board> list = new LinkedList<Board>();
	public List<Board> getList(){
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		return list;
	}
		
	}
