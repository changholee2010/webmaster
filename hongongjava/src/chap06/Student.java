package chap06;

public class Student {
	//필드(속성)
//	String stNo;
	String name;
	int kor;
	int eng;
	int math;
	
	//생성자(객체 생성) -> 객체의 속성을 초기화
	Student(String name, int kor, int eng, int math){
//		this.stNo = stNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드(기능)
	int total() {
		return kor + eng + math;
	}
	
	double avg() {
		return total() / 3.0;
	}
	
	String grade() {
		int avgVal = (int)(avg()/10);
		String gradeVal = null;
		
		switch(avgVal) {
		case 10 :
		case 9 : gradeVal = "A" ; break;
		case 8 : gradeVal = "B" ; break;
		case 7 : gradeVal = "C" ; break;
		case 6 : gradeVal = "D" ; break;
		default : gradeVal = "F" ;
		}
		return gradeVal;
	}
}
