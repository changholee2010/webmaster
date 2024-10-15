package chap06;

public class BoardMain {

	public static void main(String[] args) {
		// 객체생성
		Board b1 = new Board("제목1", "내용1");
		Board b2 = new Board("제목2", "내용2","저자2");
		Board b3 = new Board("제목3", "내용3","저자3", "2024-09-27");
		Board b4 = new Board("제목4", "내용4", "저자4", "2024-09-27", 777);
		Board b5 = new Board();
		b5.title = "제목5";
		b5.hitcount = 999;
		
		System.out.printf("%s : %s : %s : %s : %d\n", b1.title, b1.content, b1.writer, b1.date, b1.hitcount);
		System.out.printf("%s : %s : %s : %s : %d\n", b2.title, b2.content, b2.writer, b2.date, b2.hitcount);
		System.out.printf("%s : %s : %s : %s : %d\n", b3.title, b3.content, b3.writer, b3.date, b3.hitcount);
		System.out.printf("%s : %s : %s : %s : %d\n", b4.title, b4.content, b4.writer, b4.date, b4.hitcount);
		System.out.printf("%s : %s : %s : %s : %d\n", b5.title, b5.content, b5.writer, b5.date, b5.hitcount);

	}

}
