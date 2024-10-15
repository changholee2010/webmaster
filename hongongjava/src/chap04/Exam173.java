package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		// 3의 배수 갯수 출력
		
		int sum = 0;
		int cnt = 0;
		for(int i=50; i<=100;i++) {
			if(i % 3 == 0) {
				sum += i;
				cnt++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("합 = " + sum);
		System.out.println("갯수 = " + cnt);
		
		// 1에서 n 까지의 7의 배수합이 300을 넘는 순간 n값 구하기
		// 7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		// while 문
		int su = 0;
		sum = 0;
		while(true) {
			su++;
			if(su % 7 == 0) {
				sum += su;
				if(sum >= 300) break;
			}
		}
		System.out.println("7의 배수 = " + su);
		System.out.println("7의 배수 합 = " + sum);
		
		//구구단 : 중첩 for 문
		for(int i=2; i<10; i++) {
			System.out.println("=== " + i + "단 ====") ;
			for(int j=1; j<10; j++) {
				System.out.printf("%d X %d = %2d\n" , i, j, i*j);
			}
		}
		

	}//end main

}//end class
