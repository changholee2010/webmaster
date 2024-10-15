package chap01;

public class Escape88 {

	public static void main(String[] args) {
		System.out.println("abc");
		System.out.println("abc");
		System.out.println("abc");
		System.out.println("abc");
		
		// p91
		// 예제에 시작합니다 출력 되도록 변경
		
		
		// p103
		// 타입 변환
		
		//p106
		//문자열->숫자 , 숫자 -> 문자열 변환
		
		//확인문제5
		// b출력
		// b의 코드값 출력
		
		 char c1 = 'a';
		 char c2 =(char) (c1 + 1);
		 System.out.println(c2);
		 System.out.println((int)c2);
		 
		 double su1 = 3.5;
		 double su2 = 2.7;
		 String str = "홍길동";
		 int val = (int) (su1) + (int) su2;
		 System.out.printf("값은 %d 내이름은 %s %.1f\n",val, str, su1);
		 System.out.println("end");
		
		
		

	} //end main

}//end class
