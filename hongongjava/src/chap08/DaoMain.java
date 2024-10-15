package chap08;

public class DaoMain {

	public static void main(String[] args) {
		dbWork(new OracleDao());

	}

	static void dbWork(DataAceessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
	}

}
