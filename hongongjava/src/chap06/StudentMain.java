package chap06;

public class StudentMain {

	public static void main(String[] args) {
		// 객체 생성
//		Student[] students = new Student[5];
//		
//		students[0] = new Student("홍길동", 80,90,88);
//		students[1] = new Student("성춘향", 100,87,99);
//		students[2] = new Student("이몽룡", 60,70,80);
//		students[3] = new Student("아무개", 30,50,66);
//		students[4] = new Student("거시기", 100,100,100);
		
		Student[] students = {
				new Student("홍길동", 80,90,88),
				new Student("성춘향", 100,87,99),
				new Student("이몽룡", 60,70,80),
				new Student("아무개", 30,50,66),
				new Student("거시기", 100,100,100)
		};
//		
		for(Student student : students) {
			System.out.printf("%s : %4d : %4d : %4d : %4d : %6.2f : %s\n", student.name, student.kor, student.eng, student.math, student.total(), student.avg(),student.grade());
		}
		

	}

}
